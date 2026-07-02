package com.zyratechnologies.heynannie.entity;

import com.zyratechnologies.heynannie.entities.AdminUser;
import com.zyratechnologies.heynannie.entities.Nanny;
import com.zyratechnologies.heynannie.enums.DocumentStatus;
import com.zyratechnologies.heynannie.enums.DocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document_verifications")
public class DocumentVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", nullable = false)
    private AdminUser admin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nanny_id", nullable = false)
    private Nanny nanny;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentType documentType;

    @Column(nullable = false)
    private Long documentId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentStatus documentStatus;

    private String comment;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime verifiedAt;
}