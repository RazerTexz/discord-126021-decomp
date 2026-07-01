package d0.e0.p.d.m0.p;

import d0.z.d.m;

/* JADX INFO: compiled from: numbers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3564b;

    public f(String str, int i) {
        m.checkNotNullParameter(str, "number");
        this.a = str;
        this.f3564b = i;
    }

    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.f3564b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return m.areEqual(this.a, fVar.a) && this.f3564b == fVar.f3564b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f3564b;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("NumberWithRadix(number=");
        sbU.append(this.a);
        sbU.append(", radix=");
        return b.d.b.a.a.A(sbU, this.f3564b, ')');
    }
}
