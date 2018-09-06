package com.lstfight.portal.resource;

import com.lstfight.portal.entity.SysResourceEntity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 李尚庭
 * <p>在初始化bean的过程中 添加处理</p>
 * @date 2018/8/6 0006 14:22
 */
@Component
@Lazy
public class ResourcePostScan implements BeanPostProcessor {

    List<SysResourceEntity> resourceEntities = new ArrayList<>();

    private static final int METHOD = 2;
    private static final int CLASS = 1;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        //获取方法
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
        //获取类上定义的注解
        Annotation[] annotations = bean.getClass().getDeclaredAnnotations();
        //定义父资源id
        String parentId = UUID.randomUUID().toString().replace("-", "");

        ResourcePoint resourcePoint = null;
        //类上定义资源为父资源
        for (Annotation annotation : annotations) {
            if (annotation instanceof ResourcePoint) {
                resourcePoint = (ResourcePoint) annotation;
                addResource("0", parentId, resourcePoint, CLASS);
                break;
            }
        }
        if (null == resourcePoint) {
            return bean;
        }

        //方法资源为child资源
        for (Method method : methods) {
            String id = UUID.randomUUID().toString().replace("-", "");
            ResourcePoint childPoint = AnnotationUtils.findAnnotation(method, ResourcePoint.class);
            if (childPoint != null) {
                addResource(parentId, id, childPoint, METHOD);
            }
        }
        return bean;
    }

    /**
     * @param parentId      父资源ID
     * @param id            资源ID
     * @param resourcePoint 资源实体
     */
    private void addResource(String parentId, String id, ResourcePoint resourcePoint, int type) {
        SysResourceEntity resourceEntity = new SysResourceEntity();
        resourceEntity.setResourceId(id);
        resourceEntity.setResourceParentId(parentId);
        resourceEntity.setResourceName(resourcePoint.name());
        resourceEntity.setResourceCode(resourcePoint.code());
        resourceEntity.setResourceValue(resourcePoint.value());
        resourceEntity.setResourceType(type);
        resourceEntities.add(resourceEntity);
    }
}
