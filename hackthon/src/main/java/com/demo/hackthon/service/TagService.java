package com.demo.hackthon.service;

import com.demo.hackthon.dto.TagDTO;

import java.util.Optional;

public interface TagService {
    TagDTO createTag(TagDTO tagDTO);
    void deleteTag(String tagKey);
    Optional<TagDTO> getTag(String tagName);


}
