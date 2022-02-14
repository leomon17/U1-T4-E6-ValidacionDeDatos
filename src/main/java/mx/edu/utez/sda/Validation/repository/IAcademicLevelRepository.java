package mx.edu.utez.sda.Validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.utez.sda.Validation.entity.AcademicLevel;

public interface IAcademicLevelRepository extends JpaRepository<AcademicLevel, Long> {
    
}
