package com.demo.hackthon.service.impl;

import com.demo.hackthon.dto.TagDTO;
import com.demo.hackthon.entity.TagEntity;
import com.demo.hackthon.repo.TagRepo;
import com.demo.hackthon.service.TagService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
    TagRepo tagRepo;

    @Override
    public TagDTO createTag(TagDTO tagDTO) {
        if (getTag(tagDTO.getTagName()).isPresent()) {
            return getTag(tagDTO.getTagName()).get();
        }
        TagEntity tagEntity = dozerBeanMapper.map(tagDTO, TagEntity.class);
        tagRepo.save(tagEntity);
        return dozerBeanMapper.map(tagEntity, TagDTO.class);
    }

    @Override
    public void deleteTag(String tagKey) {
        tagRepo.deleteById(tagKey);
    }

    @Override
    public Optional<TagDTO> getTag(String tagName) {
        Optional<TagEntity> byTagName = tagRepo.findByTagName(tagName);
        if (byTagName.isPresent()) {
            return Optional.ofNullable(dozerBeanMapper.map(byTagName.get(), TagDTO.class));
        }
        return Optional.empty();
    }
}
