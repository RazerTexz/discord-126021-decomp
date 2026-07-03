package p007b.p225i.p226a.p288f.p313h.p323j;

import java.util.Objects;
import p007b.p225i.p226a.p288f.p291b.C3180f;

/* JADX INFO: renamed from: b.i.a.f.h.j.m */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3528m implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC3525k0 f9759j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ServiceConnectionC3526l f9760k;

    public RunnableC3528m(ServiceConnectionC3526l serviceConnectionC3526l, InterfaceC3525k0 interfaceC3525k0) {
        this.f9760k = serviceConnectionC3526l;
        this.f9759j = interfaceC3525k0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f9760k.f9756l.m4458R()) {
            return;
        }
        this.f9760k.f9756l.m4430a(3, "Connected to service after a timeout", null, null, null);
        C3522j c3522j = this.f9760k.f9756l;
        InterfaceC3525k0 interfaceC3525k0 = this.f9759j;
        Objects.requireNonNull(c3522j);
        C3180f.m3967b();
        c3522j.f9743m = interfaceC3525k0;
        c3522j.m4460T();
        C3497a c3497aM4436s = c3522j.m4436s();
        Objects.requireNonNull(c3497aM4436s);
        C3180f.m3967b();
        c3497aM4436s.f9661l.m4487O();
    }
}
