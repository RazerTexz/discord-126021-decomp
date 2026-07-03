package p007b.p109f.p161j.p169d;

import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.j.d.a */
/* JADX INFO: compiled from: BytesRange.java */
/* JADX INFO: loaded from: classes.dex */
public class C1880a {

    /* JADX INFO: renamed from: a */
    public final int f3704a;

    /* JADX INFO: renamed from: b */
    public final int f3705b;

    public C1880a(int i, int i2) {
        this.f3704a = i;
        this.f3705b = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1880a)) {
            return false;
        }
        C1880a c1880a = (C1880a) obj;
        return this.f3704a == c1880a.f3704a && this.f3705b == c1880a.f3705b;
    }

    public int hashCode() {
        return C1460d.m445J0(this.f3704a, this.f3705b);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        int i = this.f3704a;
        objArr[0] = i == Integer.MAX_VALUE ? "" : Integer.toString(i);
        int i2 = this.f3705b;
        objArr[1] = i2 != Integer.MAX_VALUE ? Integer.toString(i2) : "";
        return String.format(null, "%s-%s", objArr);
    }
}
