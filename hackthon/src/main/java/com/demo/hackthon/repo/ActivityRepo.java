package com.demo.hackthon.repo;

import com.demo.hackthon.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepo extends JpaRepository<ActivityEntity,String> {


}
