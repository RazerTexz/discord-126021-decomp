package d0.e0.p.d.m0.n.p1;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.a, reason: use source file name */
/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CapturedTypeApproximation<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f3534b;

    public CapturedTypeApproximation(T t, T t2) {
        this.a = t;
        this.f3534b = t2;
    }

    public final T component1() {
        return this.a;
    }

    public final T component2() {
        return this.f3534b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CapturedTypeApproximation)) {
            return false;
        }
        CapturedTypeApproximation capturedTypeApproximation = (CapturedTypeApproximation) obj;
        return Intrinsics3.areEqual(this.a, capturedTypeApproximation.a) && Intrinsics3.areEqual(this.f3534b, capturedTypeApproximation.f3534b);
    }

    public final T getLower() {
        return this.a;
    }

    public final T getUpper() {
        return this.f3534b;
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f3534b;
        return iHashCode + (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApproximationBounds(lower=");
        sbU.append(this.a);
        sbU.append(", upper=");
        sbU.append(this.f3534b);
        sbU.append(')');
        return sbU.toString();
    }
}
