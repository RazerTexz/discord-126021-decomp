package b.i.a.c.a3;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e0$d {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f815b;

    public e0$d(int i, boolean z2) {
        this.a = i;
        this.f815b = z2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e0$d.class != obj.getClass()) {
            return false;
        }
        e0$d e0_d = (e0$d) obj;
        return this.a == e0_d.a && this.f815b == e0_d.f815b;
    }

    public int hashCode() {
        return (this.a * 31) + (this.f815b ? 1 : 0);
    }
}
