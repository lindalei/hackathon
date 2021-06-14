package com.demo.hackthon.utils;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DozerUtils {
    @Autowired
    DozerBeanMapper dozerBeanMapper;

    public <T> T map(Object source, Class<T> targetObjectClass) {
        return dozerBeanMapper.map(source, targetObjectClass);
    }

    public <T, S> Set<T> mapSet(Set<S> sourceList, Class<T> targetObjectClass) {
        Set<T> desSet = new HashSet();
        for (S s : sourceList) {
            desSet.add(dozerBeanMapper.map(s, targetObjectClass));
        }
        return desSet;
    }
}
