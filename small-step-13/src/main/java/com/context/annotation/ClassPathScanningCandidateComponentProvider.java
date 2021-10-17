package com.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.home.beans.factory.factory.BeanDefinition;
import com.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author GTsung
 * @date 2021/10/17
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class clazz :classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
