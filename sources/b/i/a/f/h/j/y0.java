package b.i.a.f.h.j;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 {
    public final b.i.a.f.e.o.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1429b;

    public y0(b.i.a.f.e.o.b bVar) {
        Objects.requireNonNull(bVar, "null reference");
        this.a = bVar;
    }

    public final void a() {
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a);
        this.f1429b = SystemClock.elapsedRealtime();
    }

    public final boolean b(long j) {
        if (this.f1429b == 0) {
            return true;
        }
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a);
        return SystemClock.elapsedRealtime() - this.f1429b > j;
    }
}
