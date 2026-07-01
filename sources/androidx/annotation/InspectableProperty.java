package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface InspectableProperty {
    int attributeId() default 0;

    InspectableProperty$EnumEntry[] enumMapping() default {};

    InspectableProperty$FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    InspectableProperty$ValueType valueType() default InspectableProperty$ValueType.INFERRED;
}
