package com.demo.hackthon.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Set;

import static com.demo.hackthon.utils.Constants.*;

@Entity
@Table(name="tag")
public class TagEntity {
    private static final String TAG_KEY ="tagKey";
    private static final String TAG_NAME ="tagName";
    private static final String TAG_DES ="tagDes";
    @Id
    @GeneratedValue(generator = IDGEN_UUID_GENERATOR)
    @GenericGenerator(name = IDGEN_UUID_GENERATOR, strategy = IDGEN_STRATEGY)
    @Column(name = TAG_KEY, length = KEY_LENGTH_40, updatable = false)
    private String tagKey;

    @Column(name = TAG_NAME, length = NAME_LENGTH_40)
    private String tagName;
    @Column(name = TAG_DES , length = DES_LENGTH_512)
    private String tagDes;

    @ManyToMany(mappedBy = "tags")
    Set<ActivityEntity> activities;

    public String getTagKey() {
        return tagKey;
    }

    public void setTagKey(String tagKey) {
        this.tagKey = tagKey;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDes() {
        return tagDes;
    }

    public void setTagDes(String tagDes) {
        this.tagDes = tagDes;
    }
}
