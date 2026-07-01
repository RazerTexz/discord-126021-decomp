package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g<T> {
    public final T a;

    public g(T t) {
        this.a = t;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            T value = getValue();
            g gVar = obj instanceof g ? (g) obj : null;
            if (!d0.z.d.m.areEqual(value, gVar != null ? gVar.getValue() : null)) {
                return false;
            }
        }
        return true;
    }

    public abstract c0 getType(d0.e0.p.d.m0.c.c0 c0Var);

    public T getValue() {
        return this.a;
    }

    public int hashCode() {
        T value = getValue();
        if (value == null) {
            return 0;
        }
        return value.hashCode();
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
