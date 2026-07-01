package lombok.core;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: app.apk:lombok/core/FieldAugment$MapWeakFieldAugment.SCL.lombok */
class FieldAugment$MapWeakFieldAugment<T, F> extends FieldAugment$MapFieldAugment<T, F> {
    FieldAugment$MapWeakFieldAugment(F defaultValue) {
        super(defaultValue);
    }

    @Override // lombok.core.FieldAugment$MapFieldAugment
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

    @Override // lombok.core.FieldAugment$MapFieldAugment
    void write(T object, F value) {
        this.values.put(object, new WeakReference(value));
    }
}
