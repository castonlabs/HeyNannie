package com.zyratechnologies.heynannie.entity;

import com.zyratechnologies.heynannie.entities.Nanny;
import com.zyratechnologies.heynannie.enums.DocumentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "references")
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nanny_id", nullable = false)
    private Nanny nanny;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String relationship;

    @Column(nullable = false)
    private String phoneNumber;

    private String email;

    @Column(nullable = false)
    private String idNumber;

    @Column(nullable = false)
    private String idImageUrl;

    @Column(nullable = false)
    private Boolean surnameMatch;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentStatus status;

    private String rejectionReason;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime submittedAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        status = DocumentStatus.PENDING;
        surnameMatch = false;
    }
}