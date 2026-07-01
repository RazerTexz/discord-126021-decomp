package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Serializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MapSerializer$BindMap {
    Class<?> keyClass() default Object.class;

    Class<? extends Serializer> keySerializer() default Serializer.class;

    boolean keysCanBeNull() default true;

    Class<?> valueClass() default Object.class;

    Class<? extends Serializer> valueSerializer() default Serializer.class;

    boolean valuesCanBeNull() default true;
}
