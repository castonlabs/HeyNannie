package com.zyratechnologies.heynannie.entities;

import com.zyratechnologies.heynannie.enums.TierLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="nannie_tier")
public class NannieTier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @NotNull(message = "the value must not be null")
    @Enumerated(EnumType.STRING)
    private TierLevel tierLevel;

    @Column(unique = true,nullable = false)
    @NotNull(message = "the display field must not be empty")
    private String displayName;

    @Column(unique = true, nullable = false)
    @NotNull(message = "the parentlabel field must not be empty")
    private String parentLebel;

    @Column(unique = true, nullable = false)
    @NotNull(message = "the parentlabel field must not be empty")
    private String description;

}
