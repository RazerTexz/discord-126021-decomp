package p007b.p225i.p226a.p288f.p313h.p323j;

import android.os.Handler;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.h.j.a0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3498a0 {

    /* JADX INFO: renamed from: a */
    public static volatile Handler f9662a;

    /* JADX INFO: renamed from: b */
    public final C3515g f9663b;

    /* JADX INFO: renamed from: c */
    public final Runnable f9664c;

    /* JADX INFO: renamed from: d */
    public volatile long f9665d;

    public AbstractC3498a0(C3515g c3515g) {
        Objects.requireNonNull(c3515g, "null reference");
        this.f9663b = c3515g;
        this.f9664c = new RunnableC3501b0(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m4416a() {
        this.f9665d = 0L;
        m4417b().removeCallbacks(this.f9664c);
    }

    /* JADX INFO: renamed from: b */
    public final Handler m4417b() {
        Handler handler;
        if (f9662a != null) {
            return f9662a;
        }
        synchronized (AbstractC3498a0.class) {
            if (f9662a == null) {
                f9662a = new HandlerC3511e1(this.f9663b.f9722b.getMainLooper());
            }
            handler = f9662a;
        }
        return handler;
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo4418c();

    /* JADX INFO: renamed from: d */
    public final boolean m4419d() {
        return this.f9665d != 0;
    }

    /* JADX INFO: renamed from: e */
    public final void m4420e(long j) {
        m4416a();
        if (j >= 0) {
            Objects.requireNonNull((C3401c) this.f9663b.f9724d);
            this.f9665d = System.currentTimeMillis();
            if (m4417b().postDelayed(this.f9664c, j)) {
                return;
            }
            this.f9663b.m4451c().m4426A("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }
}
