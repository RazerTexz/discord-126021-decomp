package androidx.view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ClassesInfoCache$MethodReference {
    public final int mCallType;
    public final Method mMethod;

    public ClassesInfoCache$MethodReference(int i, Method method) {
        this.mCallType = i;
        this.mMethod = method;
        method.setAccessible(true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassesInfoCache$MethodReference)) {
            return false;
        }
        ClassesInfoCache$MethodReference classesInfoCache$MethodReference = (ClassesInfoCache$MethodReference) obj;
        return this.mCallType == classesInfoCache$MethodReference.mCallType && this.mMethod.getName().equals(classesInfoCache$MethodReference.mMethod.getName());
    }

    public int hashCode() {
        return this.mMethod.getName().hashCode() + (this.mCallType * 31);
    }

    public void invokeCallback(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event, Object obj) {
        try {
            int i = this.mCallType;
            if (i == 0) {
                this.mMethod.invoke(obj, new Object[0]);
            } else if (i == 1) {
                this.mMethod.invoke(obj, lifecycleOwner);
            } else {
                if (i != 2) {
                    return;
                }
                this.mMethod.invoke(obj, lifecycleOwner, lifecycle$Event);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Failed to call observer method", e2.getCause());
        }
    }
}
