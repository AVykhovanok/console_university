package com.oles.consoleuniversity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@With
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Lector head;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "departments_lectors",
        joinColumns = {@JoinColumn(name = "department_id")},
        inverseJoinColumns = {@JoinColumn(name = "lector_id")})
    @ToString.Exclude
    private Set<Lector> lectors = new LinkedHashSet<>();
}
