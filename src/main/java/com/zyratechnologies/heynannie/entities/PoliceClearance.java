package com.zyratechnologies.heynannie.entities;

import com.zyratechnologies.heynannie.enums.DocumentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "police_clearances")
public class PoliceClearance {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nanny_id", nullable = false, unique = true)
    private Nanny nanny;

    @Column(nullable = false)
    private String clearanceNumber;

    @Column(nullable = false)
    @NotNull(message = " document id must not be null")
    private String imageUrl;

    @Column(nullable = false)


    @Enumerated(EnumType.STRING)
    private DocumentStatus documentStatus;

   @Column(nullable = false)
    private String rejectionReason;

    private LocalDateTime uploadedAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCraete() {
        documentStatus = DocumentStatus.PENDING;
    }



}
