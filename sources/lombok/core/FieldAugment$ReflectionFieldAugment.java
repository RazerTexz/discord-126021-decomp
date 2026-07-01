package lombok.core;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: app.apk:lombok/core/FieldAugment$ReflectionFieldAugment.SCL.lombok */
class FieldAugment$ReflectionFieldAugment<T, F> extends FieldAugment<T, F> {
    private final Object lock;
    private final Field field;
    private final Class<F> targetType;
    private final F defaultValue;

    /* JADX WARN: Multi-variable type inference failed */
    FieldAugment$ReflectionFieldAugment(Field field, Class<? super F> cls, F defaultValue) {
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
        FieldAugment.access$1(object, "object");
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
        FieldAugment.access$1(object, "object");
        FieldAugment.access$1(value, "value");
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
        FieldAugment.access$1(object, "object");
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
        FieldAugment.access$1(object, "object");
        FieldAugment.access$1(expected, "expected");
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
        FieldAugment.access$1(object, "object");
        FieldAugment.access$1(value, "value");
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
        FieldAugment.access$1(object, "object");
        FieldAugment.access$1(expected, "expected");
        FieldAugment.access$1(value, "value");
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
