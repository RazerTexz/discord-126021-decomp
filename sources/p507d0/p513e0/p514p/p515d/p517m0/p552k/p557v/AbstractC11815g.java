package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.g */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11815g<T> {

    /* JADX INFO: renamed from: a */
    public final T f24438a;

    public AbstractC11815g(T t) {
        this.f24438a = t;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            T value = getValue();
            AbstractC11815g abstractC11815g = obj instanceof AbstractC11815g ? (AbstractC11815g) obj : null;
            if (!C12238m.areEqual(value, abstractC11815g != null ? abstractC11815g.getValue() : null)) {
                return false;
            }
        }
        return true;
    }

    public abstract AbstractC11913c0 getType(InterfaceC11325c0 interfaceC11325c0);

    public T getValue() {
        return this.f24438a;
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
