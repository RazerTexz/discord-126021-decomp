package b.a.q.o0;

/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$d {
    public Long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f282b;

    public e$d(boolean z2, long j) {
        this.a = z2 ? Long.valueOf(j) : null;
    }

    public final boolean a() {
        return this.a != null;
    }

    public final void b(boolean z2, long j) {
        Long l = this.a;
        if (l == null) {
            if (z2) {
                this.a = Long.valueOf(j);
            }
        } else if (l != null) {
            long jLongValue = l.longValue();
            if (z2) {
                return;
            }
            this.f282b = (j - jLongValue) + this.f282b;
            this.a = null;
        }
    }

    public final long c(long j) {
        Long l = this.a;
        if (l == null) {
            return this.f282b;
        }
        return (this.f282b + j) - l.longValue();
    }
}
