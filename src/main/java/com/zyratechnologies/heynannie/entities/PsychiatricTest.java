package com.zyratechnologies.heynannie.entities;
import com.zyratechnologies.heynannie.enums.DocumentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "psychiatric_tests")
public class PsychiatricTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nanny_id", nullable = false, unique = true)
    private Nanny nanny;

    @Column(nullable = false)
    private String clinicName;

    @Column(nullable = false)
    private String doctorName;

    @Column(nullable = false)
    private String certificateNumber;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private LocalDate testDate;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentStatus status;

    private String rejectionReason;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime uploadedAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        status = DocumentStatus.PENDING;
    }
}