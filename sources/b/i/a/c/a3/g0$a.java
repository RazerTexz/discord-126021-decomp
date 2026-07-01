package b.i.a.c.a3;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SampleDataQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g0$a {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f818b;
    public boolean c;

    @Nullable
    public b.i.a.c.e3.e d;

    @Nullable
    public g0$a e;

    public g0$a(long j, int i) {
        this.a = j;
        this.f818b = j + ((long) i);
    }

    public int a(long j) {
        return ((int) (j - this.a)) + this.d.f939b;
    }
}
