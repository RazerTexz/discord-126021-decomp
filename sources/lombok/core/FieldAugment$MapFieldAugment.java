package lombok.core;

import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: app.apk:lombok/core/FieldAugment$MapFieldAugment.SCL.lombok */
class FieldAugment$MapFieldAugment<T, F> extends FieldAugment<T, F> {
    final Map<T, Object> values;
    final F defaultValue;

    FieldAugment$MapFieldAugment(F defaultValue) {
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
        FieldAugment.access$1(t, "object");
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
        FieldAugment.access$1(t, "object");
        FieldAugment.access$1(f, "value");
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
        FieldAugment.access$1(t, "object");
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
        FieldAugment.access$1(t, "object");
        FieldAugment.access$1(f, "expected");
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
        FieldAugment.access$1(t, "object");
        FieldAugment.access$1(f, "value");
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
        FieldAugment.access$1(t, "object");
        FieldAugment.access$1(f, "expected");
        FieldAugment.access$1(f2, "value");
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
