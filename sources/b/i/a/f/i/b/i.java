package b.i.a.f.i.b;

import android.os.Handler;
import b.i.a.f.h.l.bc;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    public static volatile Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t5 f1535b;
    public final Runnable c;
    public volatile long d;

    public i(t5 t5Var) {
        Objects.requireNonNull(t5Var, "null reference");
        this.f1535b = t5Var;
        this.c = new k(this, t5Var);
    }

    public abstract void a();

    public final void b(long j) {
        c();
        if (j >= 0) {
            Objects.requireNonNull((b.i.a.f.e.o.c) this.f1535b.i());
            this.d = System.currentTimeMillis();
            if (d().postDelayed(this.c, j)) {
                return;
            }
            this.f1535b.g().f.b("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public final void c() {
        this.d = 0L;
        d().removeCallbacks(this.c);
    }

    public final Handler d() {
        Handler handler;
        if (a != null) {
            return a;
        }
        synchronized (i.class) {
            if (a == null) {
                a = new bc(this.f1535b.j().getMainLooper());
            }
            handler = a;
        }
        return handler;
    }
}
