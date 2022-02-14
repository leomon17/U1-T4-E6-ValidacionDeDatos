package mx.edu.utez.sda.Validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.sda.Validation.entity.Solicitud;
import mx.edu.utez.sda.Validation.entity.DataTransferObject.SolicitudDTO;
import mx.edu.utez.sda.Validation.repository.ISolicitudRepository;
@Service
public class SolicitudService {
    
    @Autowired
    private ISolicitudRepository solicitudRepository;

    public List<SolicitudDTO> findAllRequests(){
        return solicitudRepository.findAllRequests();
    }
    
    public Solicitud save(Solicitud solicitud){
        return solicitudRepository.save(solicitud);
    }
}
