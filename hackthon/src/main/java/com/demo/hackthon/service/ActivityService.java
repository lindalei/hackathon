package com.demo.hackthon.service;

import com.demo.hackthon.dto.ActivityDTO;

public interface ActivityService {
    ActivityDTO createActivity(ActivityDTO activityDTO);
    ActivityDTO updateActivity(ActivityDTO activityDTO);
    void updateActivityStatus(String activityKey);

}
