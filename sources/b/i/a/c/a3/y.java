package b.i.a.c.a3;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MediaPeriodId.java */
/* JADX INFO: loaded from: classes3.dex */
public class y {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f835b;
    public final int c;
    public final long d;
    public final int e;

    public y(y yVar) {
        this.a = yVar.a;
        this.f835b = yVar.f835b;
        this.c = yVar.c;
        this.d = yVar.d;
        this.e = yVar.e;
    }

    public boolean a() {
        return this.f835b != -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.a.equals(yVar.a) && this.f835b == yVar.f835b && this.c == yVar.c && this.d == yVar.d && this.e == yVar.e;
    }

    public int hashCode() {
        return ((((((((this.a.hashCode() + 527) * 31) + this.f835b) * 31) + this.c) * 31) + ((int) this.d)) * 31) + this.e;
    }

    public y(Object obj) {
        this.a = obj;
        this.f835b = -1;
        this.c = -1;
        this.d = -1L;
        this.e = -1;
    }

    public y(Object obj, int i, int i2, long j) {
        this.a = obj;
        this.f835b = i;
        this.c = i2;
        this.d = j;
        this.e = -1;
    }

    public y(Object obj, int i, int i2, long j, int i3) {
        this.a = obj;
        this.f835b = i;
        this.c = i2;
        this.d = j;
        this.e = i3;
    }

    public y(Object obj, long j, int i) {
        this.a = obj;
        this.f835b = -1;
        this.c = -1;
        this.d = j;
        this.e = i;
    }
}
