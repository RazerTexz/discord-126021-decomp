package b.i.a.f.h.j;

import android.os.Handler;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 {
    public static volatile Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1409b;
    public final Runnable c;
    public volatile long d;

    public a0(g gVar) {
        Objects.requireNonNull(gVar, "null reference");
        this.f1409b = gVar;
        this.c = new b0(this);
    }

    public final void a() {
        this.d = 0L;
        b().removeCallbacks(this.c);
    }

    public final Handler b() {
        Handler handler;
        if (a != null) {
            return a;
        }
        synchronized (a0.class) {
            if (a == null) {
                a = new e1(this.f1409b.f1417b.getMainLooper());
            }
            handler = a;
        }
        return handler;
    }

    public abstract void c();

    public final boolean d() {
        return this.d != 0;
    }

    public final void e(long j) {
        a();
        if (j >= 0) {
            Objects.requireNonNull((b.i.a.f.e.o.c) this.f1409b.d);
            this.d = System.currentTimeMillis();
            if (b().postDelayed(this.c, j)) {
                return;
            }
            this.f1409b.c().A("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }
}
