package com.demo.hackthon.service.impl;

import com.demo.hackthon.dto.ActivityDTO;
import com.demo.hackthon.dto.TagDTO;
import com.demo.hackthon.entity.ActivityEntity;
import com.demo.hackthon.entity.TagEntity;
import com.demo.hackthon.enums.ActivityStatus;
import com.demo.hackthon.repo.ActivityRepo;
import com.demo.hackthon.service.ActivityService;
import com.demo.hackthon.service.TagService;
import com.demo.hackthon.utils.DozerUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityRepo activityRepo;

    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    TagService tagService;


    @Override
    @Transactional
    public ActivityDTO createActivity(ActivityDTO activityDTO) {
        Set<TagDTO> tags = activityDTO.getTags();
        Set<TagDTO> savedTags= new HashSet<>();
        if (tags != null) {
            tags.forEach(tag -> savedTags.add(tagService.createTag(tag)));
        }
        ActivityEntity activityEntity = dozerUtils.map(activityDTO, ActivityEntity.class);
        activityEntity.setActivityStatus(ActivityStatus.NEW.getObjectCode());
        //should set tags here otherwise will throw exception: "save the transient instance before flushing"
        activityEntity.setTags(dozerUtils.mapSet(savedTags,TagEntity.class));
        activityRepo.save(activityEntity);
        return dozerUtils.map(activityEntity, activityDTO.getClass());
    }

    @Override
    public ActivityDTO updateActivity(ActivityDTO activityDTO) {
        return null;
    }

    @Override
    public void updateActivityStatus(String activityKey) {

    }
}
