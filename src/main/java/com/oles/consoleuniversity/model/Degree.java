package com.oles.consoleuniversity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@With
@Entity
@Table(name = "degrees")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "degrees_lectors",
        joinColumns = @JoinColumn(name = "degree_id"),
        inverseJoinColumns = @JoinColumn(name = "lector_id"))
    private List<Lector> lectors;
}