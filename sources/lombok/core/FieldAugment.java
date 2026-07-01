package lombok.core;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/core/FieldAugment.SCL.lombok */
public abstract class FieldAugment<T, F> {
    public abstract F get(T t);

    public abstract F getAndSet(T t, F f);

    public abstract F clear(T t);

    public abstract F compareAndClear(T t, F f);

    public abstract F setIfAbsent(T t, F f);

    public abstract F compareAndSet(T t, F f, F f2);

    private static Object getDefaultValue(Class<?> type) {
        if (type == Boolean.TYPE) {
            return false;
        }
        if (type == Integer.TYPE) {
            return 0;
        }
        if (!type.isPrimitive()) {
            return null;
        }
        if (type == Long.TYPE) {
            return 0L;
        }
        if (type == Short.TYPE) {
            return (short) 0;
        }
        if (type == Byte.TYPE) {
            return (byte) 0;
        }
        if (type == Character.TYPE) {
            return (char) 0;
        }
        if (type == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (type == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        return null;
    }

    public static <T, F> FieldAugment<T, F> augment(Class<T> type, Class<? super F> fieldType, String name) {
        checkNotNull(type, "type");
        checkNotNull(fieldType, "fieldType");
        checkNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Object defaultValue = getDefaultValue(fieldType);
        FieldAugment<T, F> ret = tryCreateReflectionAugment(type, fieldType, name, defaultValue);
        return ret != null ? ret : new FieldAugment$MapFieldAugment(defaultValue);
    }

    public static <T, F> FieldAugment<T, F> circularSafeAugment(Class<T> type, Class<? super F> fieldType, String name) {
        checkNotNull(type, "type");
        checkNotNull(fieldType, "fieldType");
        checkNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Object defaultValue = getDefaultValue(fieldType);
        FieldAugment<T, F> ret = tryCreateReflectionAugment(type, fieldType, name, defaultValue);
        return ret != null ? ret : new FieldAugment$MapWeakFieldAugment(defaultValue);
    }

    private static <T, F> FieldAugment<T, F> tryCreateReflectionAugment(Class<T> type, Class<? super F> fieldType, String name, F defaultValue) {
        Field f = findField(type, fieldType, name);
        if (f == null || !typeIsAssignmentCompatible(f.getType(), fieldType)) {
            return null;
        }
        return new FieldAugment$ReflectionFieldAugment(f, fieldType, defaultValue);
    }

    private static Field findField(Class<?> type, Class<?> wantedType, String name) {
        try {
            Field f = Permit.getField(type, name);
            if (Modifier.isStatic(f.getModifiers()) || Modifier.isFinal(f.getModifiers()) || !typeIsAssignmentCompatible(f.getType(), wantedType)) {
                return null;
            }
            return f;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean typeIsAssignmentCompatible(Class<?> fieldType, Class<?> wantedType) {
        if (fieldType == Object.class || fieldType == wantedType) {
            return true;
        }
        if (fieldType.isPrimitive()) {
            return fieldType == wantedType;
        }
        if (wantedType == Integer.TYPE && (fieldType == Number.class || fieldType == Integer.class)) {
            return true;
        }
        if (wantedType == Long.TYPE && (fieldType == Number.class || fieldType == Long.class)) {
            return true;
        }
        if (wantedType == Short.TYPE && (fieldType == Number.class || fieldType == Short.class)) {
            return true;
        }
        if (wantedType == Byte.TYPE && (fieldType == Number.class || fieldType == Byte.class)) {
            return true;
        }
        if (wantedType == Character.TYPE && (fieldType == Number.class || fieldType == Character.class)) {
            return true;
        }
        if (wantedType == Float.TYPE && (fieldType == Number.class || fieldType == Float.class)) {
            return true;
        }
        if (wantedType == Double.TYPE && (fieldType == Number.class || fieldType == Double.class)) {
            return true;
        }
        if (wantedType == Boolean.TYPE && fieldType == Boolean.class) {
            return true;
        }
        return fieldType.isAssignableFrom(wantedType);
    }

    private FieldAugment() {
    }

    /* synthetic */ FieldAugment(FieldAugment fieldAugment) {
        this();
    }

    public final void set(T object, F value) {
        getAndSet(object, value);
    }

    static /* synthetic */ Object access$1(Object obj, String str) {
        return checkNotNull(obj, str);
    }

    private static <T> T checkNotNull(T object, String name) {
        if (object == null) {
            throw new NullPointerException(name);
        }
        return object;
    }
}
