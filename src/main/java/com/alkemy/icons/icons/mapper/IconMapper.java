package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.entity.IconEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IconMapper {

    public IconEntity iconDTO2Entity(IconDTO dto) {
        IconEntity iconEntity = new IconEntity();
        iconEntity.setImagen(dto.getImagen());
        iconEntity.setDenominacion(dto.getDenominacion());
        iconEntity.setFechaCreacion(dto.getFechaCreacion());
        iconEntity.setAltura(dto.getAltura());
        iconEntity.setHistoria(dto.getHistoria());
        return iconEntity;
    }

    public IconDTO iconEntity2DTO(IconEntity entity) {
        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setAltura(entity.getAltura());
        dto.setHistoria(entity.getHistoria());
        return dto;
    }

    public List<IconDTO> iconEntityList2DTOList(List<IconEntity> entities) {
        List<IconDTO> dtos = new ArrayList<>();
        entities.stream().forEach(entity -> dtos.add(iconEntity2DTO(entity)));
        return dtos;
    }
}