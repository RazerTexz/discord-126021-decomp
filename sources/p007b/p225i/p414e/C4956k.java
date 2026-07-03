package p007b.p225i.p414e;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.e.k */
/* JADX INFO: compiled from: ResultPoint.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4956k {

    /* JADX INFO: renamed from: a */
    public final float f13207a;

    /* JADX INFO: renamed from: b */
    public final float f13208b;

    public C4956k(float f, float f2) {
        this.f13207a = f;
        this.f13208b = f2;
    }

    /* JADX INFO: renamed from: a */
    public static float m6922a(C4956k c4956k, C4956k c4956k2) {
        return C3404f.m4237Q(c4956k.f13207a, c4956k.f13208b, c4956k2.f13207a, c4956k2.f13208b);
    }

    /* JADX INFO: renamed from: b */
    public static void m6923b(C4956k[] c4956kArr) {
        C4956k c4956k;
        C4956k c4956k2;
        C4956k c4956k3;
        float fM6922a = m6922a(c4956kArr[0], c4956kArr[1]);
        float fM6922a2 = m6922a(c4956kArr[1], c4956kArr[2]);
        float fM6922a3 = m6922a(c4956kArr[0], c4956kArr[2]);
        if (fM6922a2 >= fM6922a && fM6922a2 >= fM6922a3) {
            c4956k = c4956kArr[0];
            c4956k2 = c4956kArr[1];
            c4956k3 = c4956kArr[2];
        } else if (fM6922a3 < fM6922a2 || fM6922a3 < fM6922a) {
            c4956k = c4956kArr[2];
            c4956k2 = c4956kArr[0];
            c4956k3 = c4956kArr[1];
        } else {
            c4956k = c4956kArr[1];
            c4956k2 = c4956kArr[0];
            c4956k3 = c4956kArr[2];
        }
        float f = c4956k.f13207a;
        float f2 = c4956k.f13208b;
        if (((c4956k2.f13208b - f2) * (c4956k3.f13207a - f)) - ((c4956k2.f13207a - f) * (c4956k3.f13208b - f2)) < 0.0f) {
            C4956k c4956k4 = c4956k3;
            c4956k3 = c4956k2;
            c4956k2 = c4956k4;
        }
        c4956kArr[0] = c4956k2;
        c4956kArr[1] = c4956k;
        c4956kArr[2] = c4956k3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C4956k) {
            C4956k c4956k = (C4956k) obj;
            if (this.f13207a == c4956k.f13207a && this.f13208b == c4956k.f13208b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f13208b) + (Float.floatToIntBits(this.f13207a) * 31);
    }

    public final String toString() {
        return "(" + this.f13207a + ',' + this.f13208b + ')';
    }
}
