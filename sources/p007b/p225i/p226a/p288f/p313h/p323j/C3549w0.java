package p007b.p225i.p226a.p288f.p313h.p323j;

/* JADX INFO: renamed from: b.i.a.f.h.j.w0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3549w0 implements InterfaceC3507d0 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Runnable f9818a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C3543t0 f9819b;

    public C3549w0(C3543t0 c3543t0, Runnable runnable) {
        this.f9819b = c3543t0;
        this.f9818a = runnable;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3507d0
    /* JADX INFO: renamed from: a */
    public final void mo4441a(Throwable th) {
        this.f9819b.f9801b.post(this.f9818a);
    }
}
