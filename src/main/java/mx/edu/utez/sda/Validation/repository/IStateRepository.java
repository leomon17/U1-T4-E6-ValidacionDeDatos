package mx.edu.utez.sda.Validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.utez.sda.Validation.entity.State;

public interface IStateRepository extends JpaRepository<State, Long>{
    
}
