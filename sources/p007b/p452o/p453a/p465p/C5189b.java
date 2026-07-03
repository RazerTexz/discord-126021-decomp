package p007b.p452o.p453a.p465p;

import androidx.annotation.NonNull;
import p007b.p452o.p453a.C5103b;

/* JADX INFO: renamed from: b.o.a.p.b */
/* JADX INFO: compiled from: Frame.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5189b {

    /* JADX INFO: renamed from: a */
    public static final C5103b f14053a = new C5103b(C5189b.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    public final AbstractC5190c f14054b;

    /* JADX INFO: renamed from: c */
    public Object f14055c = null;

    /* JADX INFO: renamed from: d */
    public long f14056d = -1;

    /* JADX INFO: renamed from: e */
    public long f14057e = -1;

    public C5189b(@NonNull AbstractC5190c abstractC5190c) {
        this.f14054b = abstractC5190c;
    }

    /* JADX INFO: renamed from: a */
    public long m7383a() {
        if (this.f14055c != null) {
            return this.f14056d;
        }
        f14053a.m7159a(3, "Frame is dead! time:", Long.valueOf(this.f14056d), "lastTime:", Long.valueOf(this.f14057e));
        throw new RuntimeException("You should not access a released frame. If this frame was passed to a FrameProcessor, you can only use its contents synchronously, for the duration of the process() method.");
    }

    /* JADX INFO: renamed from: b */
    public void m7384b() {
        if (this.f14055c != null) {
            f14053a.m7159a(0, "Frame with time", Long.valueOf(this.f14056d), "is being released.");
            Object obj = this.f14055c;
            this.f14055c = null;
            this.f14056d = -1L;
            AbstractC5190c abstractC5190c = this.f14054b;
            if (abstractC5190c.m7386b()) {
                abstractC5190c.mo7380c(obj, abstractC5190c.f14064g.offer(this));
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C5189b) && ((C5189b) obj).f14056d == this.f14056d;
    }
}
