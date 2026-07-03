package p507d0.p580t;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.z */
/* JADX INFO: compiled from: IndexedValue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12168z<T> {

    /* JADX INFO: renamed from: a */
    public final int f25224a;

    /* JADX INFO: renamed from: b */
    public final T f25225b;

    public C12168z(int i, T t) {
        this.f25224a = i;
        this.f25225b = t;
    }

    public final int component1() {
        return this.f25224a;
    }

    public final T component2() {
        return this.f25225b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12168z)) {
            return false;
        }
        C12168z c12168z = (C12168z) obj;
        return this.f25224a == c12168z.f25224a && C12238m.areEqual(this.f25225b, c12168z.f25225b);
    }

    public final int getIndex() {
        return this.f25224a;
    }

    public final T getValue() {
        return this.f25225b;
    }

    public int hashCode() {
        int i = this.f25224a * 31;
        T t = this.f25225b;
        return i + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("IndexedValue(index=");
        sbM833U.append(this.f25224a);
        sbM833U.append(", value=");
        sbM833U.append(this.f25225b);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
