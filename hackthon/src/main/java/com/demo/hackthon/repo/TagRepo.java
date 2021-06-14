package com.demo.hackthon.repo;

import com.demo.hackthon.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepo extends JpaRepository<TagEntity,String> {

    Optional<TagEntity> findByTagName(String tagName);

    @Override
    void deleteById(String tagKey);
}
