package com.oles.consoleuniversity.repository;

import com.oles.consoleuniversity.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("select distinct l "
        +  "from Lector l "
        +  "where l.firstName like %:template% or l.lastName like :template")
    List<Lector> getLectorByTemplate(String template);

}