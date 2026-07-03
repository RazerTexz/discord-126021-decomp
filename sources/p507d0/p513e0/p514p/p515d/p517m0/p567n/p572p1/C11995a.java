package p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.a */
/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11995a<T> {

    /* JADX INFO: renamed from: a */
    public final T f24856a;

    /* JADX INFO: renamed from: b */
    public final T f24857b;

    public C11995a(T t, T t2) {
        this.f24856a = t;
        this.f24857b = t2;
    }

    public final T component1() {
        return this.f24856a;
    }

    public final T component2() {
        return this.f24857b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11995a)) {
            return false;
        }
        C11995a c11995a = (C11995a) obj;
        return C12238m.areEqual(this.f24856a, c11995a.f24856a) && C12238m.areEqual(this.f24857b, c11995a.f24857b);
    }

    public final T getLower() {
        return this.f24856a;
    }

    public final T getUpper() {
        return this.f24857b;
    }

    public int hashCode() {
        T t = this.f24856a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f24857b;
        return iHashCode + (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApproximationBounds(lower=");
        sbM833U.append(this.f24856a);
        sbM833U.append(", upper=");
        sbM833U.append(this.f24857b);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
