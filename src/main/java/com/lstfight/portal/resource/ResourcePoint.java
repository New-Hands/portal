package com.lstfight.portal.resource;

import java.lang.annotation.*;

/**
 * @date 2018/8/6 0006 14:15
 * @author 李尚庭
 *
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourcePoint {

    String name() default "";

    String code() default "";

    String value() default "";

}
