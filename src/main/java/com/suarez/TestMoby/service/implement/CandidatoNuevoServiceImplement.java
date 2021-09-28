package com.suarez.TestMoby.service.implement;

import com.suarez.TestMoby.model.entities.CandidatoNuevo;
import com.suarez.TestMoby.model.views.CrearCandidatoDto;
import com.suarez.TestMoby.repository.CandidatoNuevoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

public class CandidatoNuevoServiceImplement {

    @Autowired
    CandidatoNuevoRepository candidatoNuevoRepository;

    @Override
    public Boolean guardar(CrearCandidatoDto dto) throws ParseException {
        Integer id = cargarCandidato(dto).getId();
        return candidatoNuevoRepository.existsById(id);
    }

    @Override
    public boolean existePorDocumento(String documento) {
        return candidatoNuevoRepository.existsByDocumento(documento);
    }

    @Override
    public CandidatoNuevo cargarCandidato(CrearCandidatoDto dto) {

        if (existePorDocumento(dto.getDni()))
            throw new DocumentoExistenteException();
        if (dto.getTecnologias().isEmpty())
            throw new RequiredDataException("Debe ingresar al menos una tecnología.");

        Ubicacion ubicacionGuardada = guardarUbicacion(dto);

        CandidatoNuevo candidato = CandidatoNuevo.builder()
                .cv(dto.getCv())
                .apellido(dto.getApellido())
                .documento(dto.getDocumento())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .nombre(dto.getNombre())
                .linkedin(dto.getLinkedin())
                .referido(dto.getReferido())
                .reubicar(dto.isReubicar())
                .viajar(dto.isViajar())
                .tipo(dto.getTipo())
                .ubicacion(ubicacionGuardada)
                .imagenUrl(dto.getImagenUrl())
                .pdf(dto.getPdf())
                .build();

        CandidatoNuevo candidatoGuardado = candidatoNuevoRepository.save(candidato);


        guardarListTecnologias(dto, candidatoGuardado);

        guardarListEstudios(dto, candidatoGuardado);
        guardarListIdiomaXCandidato(dto, candidatoGuardado);

        guardarListExperienciaLaboral(dto, candidatoGuardado);

        return candidatoGuardado;
    }
}
