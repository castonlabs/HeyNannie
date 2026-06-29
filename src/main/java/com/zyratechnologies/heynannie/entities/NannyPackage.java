package com.zyratechnologies.heynannie.entities;
import com.zyratechnologies.heynannie.enums.PackageStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class NannyPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nanny_id", nullable = false)
    private Nannie nannie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tier_id", nullable = false)
    private NannieTier tier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PackageStatus status;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime assignedAt;

  @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        status = PackageStatus.ACTIVE;
    }
}
