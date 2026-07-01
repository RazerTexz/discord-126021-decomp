package lombok.core;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.WeakHashMap;
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
        return ret != null ? ret : new MapFieldAugment(defaultValue);
    }

    public static <T, F> FieldAugment<T, F> circularSafeAugment(Class<T> type, Class<? super F> fieldType, String name) {
        checkNotNull(type, "type");
        checkNotNull(fieldType, "fieldType");
        checkNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Object defaultValue = getDefaultValue(fieldType);
        FieldAugment<T, F> ret = tryCreateReflectionAugment(type, fieldType, name, defaultValue);
        return ret != null ? ret : new MapWeakFieldAugment(defaultValue);
    }

    private static <T, F> FieldAugment<T, F> tryCreateReflectionAugment(Class<T> type, Class<? super F> fieldType, String name, F defaultValue) {
        Field f = findField(type, fieldType, name);
        if (f == null || !typeIsAssignmentCompatible(f.getType(), fieldType)) {
            return null;
        }
        return new ReflectionFieldAugment(f, fieldType, defaultValue);
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

    /* JADX INFO: loaded from: app.apk:lombok/core/FieldAugment$ReflectionFieldAugment.SCL.lombok */
    private static class ReflectionFieldAugment<T, F> extends FieldAugment<T, F> {
        private final Object lock;
        private final Field field;
        private final Class<F> targetType;
        private final F defaultValue;

        /* JADX WARN: Multi-variable type inference failed */
        ReflectionFieldAugment(Field field, Class<? super F> cls, F defaultValue) {
            super(null);
            this.lock = new Object();
            this.field = field;
            this.targetType = cls;
            this.defaultValue = defaultValue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r0v9 */
        @Override // lombok.core.FieldAugment
        public F get(T object) {
            FieldAugment.checkNotNull(object, "object");
            try {
                ?? r0 = this.lock;
                synchronized (r0) {
                    try {
                        F value = this.targetType.cast(this.field.get(object));
                        r0 = r0;
                        return value == null ? this.defaultValue : value;
                    } catch (Throwable th) {
                        throw r0;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Throwable] */
        @Override // lombok.core.FieldAugment
        public F getAndSet(T object, F value) {
            FieldAugment.checkNotNull(object, "object");
            FieldAugment.checkNotNull(value, "value");
            try {
                ?? r0 = this.lock;
                synchronized (r0) {
                    try {
                        F oldValue = this.targetType.cast(this.field.get(object));
                        this.field.set(object, value);
                        r0 = r0;
                        return oldValue == null ? this.defaultValue : oldValue;
                    } catch (Throwable th) {
                        throw r0;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Throwable] */
        @Override // lombok.core.FieldAugment
        public F clear(T object) {
            FieldAugment.checkNotNull(object, "object");
            try {
                ?? r0 = this.lock;
                synchronized (r0) {
                    try {
                        F oldValue = this.targetType.cast(this.field.get(object));
                        this.field.set(object, this.defaultValue);
                        r0 = r0;
                        return oldValue == null ? this.defaultValue : oldValue;
                    } catch (Throwable th) {
                        throw r0;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.lang.Throwable] */
        @Override // lombok.core.FieldAugment
        public F compareAndClear(T object, F expected) {
            FieldAugment.checkNotNull(object, "object");
            FieldAugment.checkNotNull(expected, "expected");
            try {
                ?? r0 = this.lock;
                synchronized (r0) {
                    try {
                        F oldValue = this.targetType.cast(this.field.get(object));
                        if (expected.equals(oldValue)) {
                            this.field.set(object, this.defaultValue);
                            return this.defaultValue;
                        }
                        return oldValue;
                    } catch (Throwable th) {
                        throw r0;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.lang.Throwable] */
        @Override // lombok.core.FieldAugment
        public F setIfAbsent(T object, F value) {
            FieldAugment.checkNotNull(object, "object");
            FieldAugment.checkNotNull(value, "value");
            try {
                ?? r0 = this.lock;
                synchronized (r0) {
                    try {
                        F oldValue = this.targetType.cast(this.field.get(object));
                        if (oldValue != null && !oldValue.equals(this.defaultValue)) {
                            return oldValue;
                        }
                        this.field.set(object, value);
                        return value;
                    } catch (Throwable th) {
                        throw r0;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }

        /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, java.lang.Throwable] */
        @Override // lombok.core.FieldAugment
        public F compareAndSet(T object, F expected, F value) {
            FieldAugment.checkNotNull(object, "object");
            FieldAugment.checkNotNull(expected, "expected");
            FieldAugment.checkNotNull(value, "value");
            try {
                ?? r0 = this.lock;
                synchronized (r0) {
                    try {
                        F oldValue = this.targetType.cast(this.field.get(object));
                        if (!expected.equals(oldValue)) {
                            return oldValue == null ? this.defaultValue : oldValue;
                        }
                        this.field.set(object, value);
                        return value;
                    } catch (Throwable th) {
                        throw r0;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/core/FieldAugment$MapFieldAugment.SCL.lombok */
    private static class MapFieldAugment<T, F> extends FieldAugment<T, F> {
        final Map<T, Object> values;
        final F defaultValue;

        MapFieldAugment(F defaultValue) {
            super(null);
            this.values = new WeakHashMap();
            this.defaultValue = defaultValue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map<T, java.lang.Object>] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r0v6, types: [F, java.lang.Object] */
        @Override // lombok.core.FieldAugment
        public F get(T t) {
            FieldAugment.checkNotNull(t, "object");
            F f = this.values;
            synchronized (f) {
                try {
                    f = read(t);
                } catch (Throwable th) {
                    throw f;
                }
            }
            return f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [F] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.util.Map<T, java.lang.Object>] */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Throwable] */
        @Override // lombok.core.FieldAugment
        public F getAndSet(T t, F f) {
            FieldAugment.checkNotNull(t, "object");
            FieldAugment.checkNotNull(f, "value");
            F f2 = this.values;
            synchronized (f2) {
                try {
                    F f3 = read(t);
                    write(t, f);
                    f2 = f3;
                } catch (Throwable th) {
                    throw f2;
                }
            }
            return f2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [F] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map<T, java.lang.Object>] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Throwable] */
        @Override // lombok.core.FieldAugment
        public F clear(T t) {
            FieldAugment.checkNotNull(t, "object");
            F f = this.values;
            synchronized (f) {
                try {
                    F f2 = read(t);
                    this.values.remove(t);
                    f = f2;
                } catch (Throwable th) {
                    throw f;
                }
            }
            return f;
        }

        @Override // lombok.core.FieldAugment
        public F compareAndClear(T t, F f) {
            FieldAugment.checkNotNull(t, "object");
            FieldAugment.checkNotNull(f, "expected");
            Map<T, Object> map = this.values;
            synchronized (map) {
                try {
                    F f2 = read(t);
                    if (f2 == null) {
                        return null;
                    }
                    if (!f.equals(f2)) {
                        return f2;
                    }
                    this.values.remove(t);
                    return null;
                } catch (Throwable th) {
                    throw map;
                }
            }
        }

        @Override // lombok.core.FieldAugment
        public F setIfAbsent(T t, F f) {
            FieldAugment.checkNotNull(t, "object");
            FieldAugment.checkNotNull(f, "value");
            Map<T, Object> map = this.values;
            synchronized (map) {
                try {
                    F f2 = read(t);
                    if (f2 != null) {
                        return f2;
                    }
                    write(t, f);
                    return f;
                } catch (Throwable th) {
                    throw map;
                }
            }
        }

        @Override // lombok.core.FieldAugment
        public F compareAndSet(T t, F f, F f2) {
            FieldAugment.checkNotNull(t, "object");
            FieldAugment.checkNotNull(f, "expected");
            FieldAugment.checkNotNull(f2, "value");
            Map<T, Object> map = this.values;
            synchronized (map) {
                try {
                    F f3 = read(t);
                    if (!f.equals(f3)) {
                        return f3;
                    }
                    write(t, f2);
                    return f2;
                } catch (Throwable th) {
                    throw map;
                }
            }
        }

        F read(T t) {
            F f = (F) this.values.get(t);
            return f == null ? this.defaultValue : f;
        }

        void write(T object, F value) {
            this.values.put(object, value);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/core/FieldAugment$MapWeakFieldAugment.SCL.lombok */
    static class MapWeakFieldAugment<T, F> extends MapFieldAugment<T, F> {
        MapWeakFieldAugment(F defaultValue) {
            super(defaultValue);
        }

        @Override // lombok.core.FieldAugment.MapFieldAugment
        F read(T object) {
            WeakReference<F> read = (WeakReference) this.values.get(object);
            if (read == null) {
                return this.defaultValue;
            }
            F result = read.get();
            if (result == null) {
                this.values.remove(object);
            }
            return result == null ? this.defaultValue : result;
        }

        @Override // lombok.core.FieldAugment.MapFieldAugment
        void write(T object, F value) {
            this.values.put(object, new WeakReference(value));
        }
    }

    private static <T> T checkNotNull(T object, String name) {
        if (object == null) {
            throw new NullPointerException(name);
        }
        return object;
    }
}
