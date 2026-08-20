package com.zwitserloot.cmdreader;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: discord-126021.apk:com/zwitserloot/cmdreader/Mandatory.SCL.lombok */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Mandatory {
    String[] onlyIf() default {};

    String[] onlyIfNot() default {};
}
