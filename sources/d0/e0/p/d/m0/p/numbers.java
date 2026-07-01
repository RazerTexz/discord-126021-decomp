package d0.e0.p.d.m0.p;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.f, reason: use source file name */
/* JADX INFO: compiled from: numbers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class numbers {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3564b;

    public numbers(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "number");
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
        if (!(obj instanceof numbers)) {
            return false;
        }
        numbers numbersVar = (numbers) obj;
        return Intrinsics3.areEqual(this.a, numbersVar.a) && this.f3564b == numbersVar.f3564b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f3564b;
    }

    public String toString() {
        StringBuilder sbU = outline.U("NumberWithRadix(number=");
        sbU.append(this.a);
        sbU.append(", radix=");
        return outline.A(sbU, this.f3564b, ')');
    }
}
