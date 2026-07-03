package p007b.p109f.p161j.p169d;

import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.j.d.e */
/* JADX INFO: compiled from: ResizeOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class C1884e {

    /* JADX INFO: renamed from: a */
    public final int f3717a;

    /* JADX INFO: renamed from: b */
    public final int f3718b;

    /* JADX INFO: renamed from: c */
    public final float f3719c;

    /* JADX INFO: renamed from: d */
    public final float f3720d;

    public C1884e(int i, int i2) {
        C1460d.m527i(Boolean.valueOf(i > 0));
        C1460d.m527i(Boolean.valueOf(i2 > 0));
        this.f3717a = i;
        this.f3718b = i2;
        this.f3719c = 2048.0f;
        this.f3720d = 0.6666667f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1884e)) {
            return false;
        }
        C1884e c1884e = (C1884e) obj;
        return this.f3717a == c1884e.f3717a && this.f3718b == c1884e.f3718b;
    }

    public int hashCode() {
        return C1460d.m445J0(this.f3717a, this.f3718b);
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.f3717a), Integer.valueOf(this.f3718b));
    }
}
