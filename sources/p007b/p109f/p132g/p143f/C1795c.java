package p007b.p109f.p132g.p143f;

import androidx.annotation.ColorInt;
import java.util.Arrays;
import p007b.p085c.p086a.p095y.C1563b;

/* JADX INFO: renamed from: b.f.g.f.c */
/* JADX INFO: compiled from: RoundingParams.java */
/* JADX INFO: loaded from: classes.dex */
public class C1795c {

    /* JADX INFO: renamed from: a */
    public int f3471a = 2;

    /* JADX INFO: renamed from: b */
    public boolean f3472b = false;

    /* JADX INFO: renamed from: c */
    public float[] f3473c = null;

    /* JADX INFO: renamed from: d */
    public int f3474d = 0;

    /* JADX INFO: renamed from: e */
    public float f3475e = 0.0f;

    /* JADX INFO: renamed from: f */
    public int f3476f = 0;

    /* JADX INFO: renamed from: g */
    public float f3477g = 0.0f;

    /* JADX INFO: renamed from: h */
    public boolean f3478h = false;

    /* JADX INFO: renamed from: a */
    public static C1795c m1124a(float f) {
        C1795c c1795c = new C1795c();
        if (c1795c.f3473c == null) {
            c1795c.f3473c = new float[8];
        }
        Arrays.fill(c1795c.f3473c, f);
        return c1795c;
    }

    /* JADX INFO: renamed from: b */
    public C1795c m1125b(@ColorInt int i) {
        this.f3474d = i;
        this.f3471a = 1;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1795c.class != obj.getClass()) {
            return false;
        }
        C1795c c1795c = (C1795c) obj;
        if (this.f3472b == c1795c.f3472b && this.f3474d == c1795c.f3474d && Float.compare(c1795c.f3475e, this.f3475e) == 0 && this.f3476f == c1795c.f3476f && Float.compare(c1795c.f3477g, this.f3477g) == 0 && this.f3471a == c1795c.f3471a && this.f3478h == c1795c.f3478h) {
            return Arrays.equals(this.f3473c, c1795c.f3473c);
        }
        return false;
    }

    public int hashCode() {
        int i = this.f3471a;
        int iM758h = (((i != 0 ? C1563b.m758h(i) : 0) * 31) + (this.f3472b ? 1 : 0)) * 31;
        float[] fArr = this.f3473c;
        int iHashCode = (((iM758h + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.f3474d) * 31;
        float f = this.f3475e;
        int iFloatToIntBits = (((iHashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.f3476f) * 31;
        float f2 = this.f3477g;
        return ((((iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + 0) * 31) + (this.f3478h ? 1 : 0);
    }
}
