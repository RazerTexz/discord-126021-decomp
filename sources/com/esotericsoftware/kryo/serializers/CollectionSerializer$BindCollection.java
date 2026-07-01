package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Serializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CollectionSerializer$BindCollection {
    Class<?> elementClass() default Object.class;

    Class<? extends Serializer> elementSerializer() default Serializer.class;

    boolean elementsCanBeNull() default true;
}
