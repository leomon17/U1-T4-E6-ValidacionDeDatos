package mx.edu.utez.sda.Validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.utez.sda.Validation.entity.Municipality;

public interface IMunicipalityRepository extends JpaRepository<Municipality, Long> {
    
}
