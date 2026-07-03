package p007b.p225i.p226a.p288f.p313h.p323j;

import android.os.RemoteException;
import java.util.Collections;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p291b.C3180f;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;

/* JADX INFO: renamed from: b.i.a.f.h.j.j */
/* JADX INFO: loaded from: classes3.dex */
public final class C3522j extends AbstractC3509e {

    /* JADX INFO: renamed from: l */
    public final ServiceConnectionC3526l f9742l;

    /* JADX INFO: renamed from: m */
    public InterfaceC3525k0 f9743m;

    /* JADX INFO: renamed from: n */
    public final AbstractC3498a0 f9744n;

    /* JADX INFO: renamed from: o */
    public final C3553y0 f9745o;

    public C3522j(C3515g c3515g) {
        super(c3515g);
        this.f9745o = new C3553y0(c3515g.f9724d);
        this.f9742l = new ServiceConnectionC3526l(this);
        this.f9744n = new C3524k(this, c3515g);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3509e
    /* JADX INFO: renamed from: L */
    public final void mo4414L() {
    }

    /* JADX INFO: renamed from: O */
    public final void m4457O() {
        C3180f.m3967b();
        m4444N();
        try {
            C3398a.m4181b().m4183c(this.f9684j.f9722b, this.f9742l);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.f9743m != null) {
            this.f9743m = null;
            C3497a c3497aM4436s = m4436s();
            c3497aM4436s.m4444N();
            C3180f.m3967b();
            C3538r c3538r = c3497aM4436s.f9661l;
            C3180f.m3967b();
            c3538r.m4444N();
            c3538r.m4427C("Service disconnected");
        }
    }

    /* JADX INFO: renamed from: R */
    public final boolean m4458R() {
        C3180f.m3967b();
        m4444N();
        return this.f9743m != null;
    }

    /* JADX INFO: renamed from: S */
    public final boolean m4459S(C3523j0 c3523j0) {
        Objects.requireNonNull(c3523j0, "null reference");
        C3180f.m3967b();
        m4444N();
        InterfaceC3525k0 interfaceC3525k0 = this.f9743m;
        if (interfaceC3525k0 == null) {
            return false;
        }
        try {
            interfaceC3525k0.mo4463g0(c3523j0.f9746a, c3523j0.f9749d, c3523j0.f9751f ? C3554z.m4510d() : C3554z.m4511e(), Collections.emptyList());
            m4460T();
            return true;
        } catch (RemoteException unused) {
            m4427C("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    /* JADX INFO: renamed from: T */
    public final void m4460T() {
        this.f9745o.m4506a();
        this.f9744n.m4420e(C3510e0.f9712x.f9716a.longValue());
    }
}
