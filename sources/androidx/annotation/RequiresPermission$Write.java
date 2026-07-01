package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface RequiresPermission$Write {
    RequiresPermission value() default @RequiresPermission;
}
