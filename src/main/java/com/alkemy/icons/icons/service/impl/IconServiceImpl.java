package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconMapper iconMapper;

    @Autowired
    private IconRepository iconRepository;

    public IconDTO save(IconDTO dto) {
        IconEntity entity = iconMapper.iconDTO2Entity(dto);
        IconEntity entitySaved = iconRepository.save(entity);
        IconDTO result = iconMapper.iconEntity2DTO(entitySaved);
        return result;
    }

    public List<IconDTO> getAllIconos() {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconDTO> result = iconMapper.iconEntityList2DTOList(entities);
        return result;
    }

    @Override
    public IconDTO update(Long id, IconDTO icon) {
        IconEntity entity = iconMapper.iconDTO2Entity(icon);
        iconRepository.getReferenceById(id).setImagen(entity.getImagen());
        iconRepository.getReferenceById(id).setDenominacion(entity.getDenominacion());
        iconRepository.getReferenceById(id).setFechaCreacion(entity.getFechaCreacion());
        iconRepository.getReferenceById(id).setAltura(entity.getAltura());
        iconRepository.getReferenceById(id).setHistoria(entity.getHistoria());
        IconDTO result = iconMapper.iconEntity2DTO(iconRepository.getReferenceById(id));
        return result;
    }
}