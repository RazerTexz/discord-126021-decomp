package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Handler;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p313h.p325l.HandlerC3604bc;

/* JADX INFO: renamed from: b.i.a.f.i.b.i */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4064i {

    /* JADX INFO: renamed from: a */
    public static volatile Handler f10798a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC4192t5 f10799b;

    /* JADX INFO: renamed from: c */
    public final Runnable f10800c;

    /* JADX INFO: renamed from: d */
    public volatile long f10801d;

    public AbstractC4064i(InterfaceC4192t5 interfaceC4192t5) {
        Objects.requireNonNull(interfaceC4192t5, "null reference");
        this.f10799b = interfaceC4192t5;
        this.f10800c = new RunnableC4087k(this, interfaceC4192t5);
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo5560a();

    /* JADX INFO: renamed from: b */
    public final void m5663b(long j) {
        m5664c();
        if (j >= 0) {
            Objects.requireNonNull((C3401c) this.f10799b.mo5728i());
            this.f10801d = System.currentTimeMillis();
            if (m5665d().postDelayed(this.f10800c, j)) {
                return;
            }
            this.f10799b.mo5726g().f11141f.m5861b("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m5664c() {
        this.f10801d = 0L;
        m5665d().removeCallbacks(this.f10800c);
    }

    /* JADX INFO: renamed from: d */
    public final Handler m5665d() {
        Handler handler;
        if (f10798a != null) {
            return f10798a;
        }
        synchronized (AbstractC4064i.class) {
            if (f10798a == null) {
                f10798a = new HandlerC3604bc(this.f10799b.mo5729j().getMainLooper());
            }
            handler = f10798a;
        }
        return handler;
    }
}
