package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.a3.y */
/* JADX INFO: compiled from: MediaPeriodId.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2571y {

    /* JADX INFO: renamed from: a */
    public final Object f5732a;

    /* JADX INFO: renamed from: b */
    public final int f5733b;

    /* JADX INFO: renamed from: c */
    public final int f5734c;

    /* JADX INFO: renamed from: d */
    public final long f5735d;

    /* JADX INFO: renamed from: e */
    public final int f5736e;

    public C2571y(C2571y c2571y) {
        this.f5732a = c2571y.f5732a;
        this.f5733b = c2571y.f5733b;
        this.f5734c = c2571y.f5734c;
        this.f5735d = c2571y.f5735d;
        this.f5736e = c2571y.f5736e;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2593a() {
        return this.f5733b != -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2571y)) {
            return false;
        }
        C2571y c2571y = (C2571y) obj;
        return this.f5732a.equals(c2571y.f5732a) && this.f5733b == c2571y.f5733b && this.f5734c == c2571y.f5734c && this.f5735d == c2571y.f5735d && this.f5736e == c2571y.f5736e;
    }

    public int hashCode() {
        return ((((((((this.f5732a.hashCode() + 527) * 31) + this.f5733b) * 31) + this.f5734c) * 31) + ((int) this.f5735d)) * 31) + this.f5736e;
    }

    public C2571y(Object obj) {
        this.f5732a = obj;
        this.f5733b = -1;
        this.f5734c = -1;
        this.f5735d = -1L;
        this.f5736e = -1;
    }

    public C2571y(Object obj, int i, int i2, long j) {
        this.f5732a = obj;
        this.f5733b = i;
        this.f5734c = i2;
        this.f5735d = j;
        this.f5736e = -1;
    }

    public C2571y(Object obj, int i, int i2, long j, int i3) {
        this.f5732a = obj;
        this.f5733b = i;
        this.f5734c = i2;
        this.f5735d = j;
        this.f5736e = i3;
    }

    public C2571y(Object obj, long j, int i) {
        this.f5732a = obj;
        this.f5733b = -1;
        this.f5734c = -1;
        this.f5735d = j;
        this.f5736e = i;
    }
}
