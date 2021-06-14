package com.demo.hackthon.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Set;

import static com.demo.hackthon.utils.Constants.*;

@Entity
@Table(name = "activity")
public class ActivityEntity {
    private static final String ACTIVITY_KEY = "activityKey";
    private static final String ACTIVITY_NAME = "activityName";
    private static final String ACTIVITY_DES = "activityDes";
    private static final String ACTIVITY_CATEGORY_CODE = "categoryCode";
    private static final String ACTIVITY_STATUS = "activityStatus";

    @Id
    @GeneratedValue(generator = IDGEN_UUID_GENERATOR)
    @GenericGenerator(name = IDGEN_UUID_GENERATOR, strategy = IDGEN_STRATEGY)
    @Column(name = ACTIVITY_KEY, length = KEY_LENGTH_40, updatable = false)
    String activityKey;

    @Column(name = ACTIVITY_NAME, length = NAME_LENGTH_40)
    String activityName;
    @Column(name = ACTIVITY_DES, length = DES_LENGTH_512)
    String activityDes;
    @Column(name = ACTIVITY_CATEGORY_CODE, length = KEY_LENGTH_40, updatable = false)
    String categoryCode;


    @ManyToMany
    @JoinTable(name = "activity_tag",
            joinColumns = @JoinColumn(name = "activityKey"),
            inverseJoinColumns = @JoinColumn(name = "tagKey"))
    Set<TagEntity> tags;

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    @Column(name = ACTIVITY_STATUS, length = STATUS_LENGTH_16)
    private String activityStatus;

    public Set<TagEntity> getTags() {
        return tags;
    }

    public void setTags(Set<TagEntity> tags) {
        this.tags = tags;
    }

    public String getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(String activityKey) {
        this.activityKey = activityKey;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDes() {
        return activityDes;
    }

    public void setActivityDes(String activityDes) {
        this.activityDes = activityDes;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
