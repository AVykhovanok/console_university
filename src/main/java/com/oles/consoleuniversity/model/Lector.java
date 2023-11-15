package com.oles.consoleuniversity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
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
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Double salary;

    @ManyToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @ManyToMany(mappedBy = "lectors", fetch = FetchType.LAZY)
    private Set<Department> departments = new HashSet<>();

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
