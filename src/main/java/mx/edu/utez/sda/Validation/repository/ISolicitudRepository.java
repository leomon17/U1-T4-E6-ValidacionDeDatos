package mx.edu.utez.sda.Validation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.utez.sda.Validation.entity.Solicitud;
import mx.edu.utez.sda.Validation.entity.DataTransferObject.SolicitudDTO;

public interface ISolicitudRepository extends JpaRepository<Solicitud, Long>{
    
    @Query("SELECT NEW mx.edu.utez.sda.Validation.entity.DataTransferObject.SolicitudDTO(s.id, s.name, s.lastname, s.surname) FROM Solicitud s")
    List<SolicitudDTO> findAllRequests();
}
