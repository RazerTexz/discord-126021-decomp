package b.i.a.f.h.j;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements d0 {
    public final /* synthetic */ Runnable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t0 f1428b;

    public w0(t0 t0Var, Runnable runnable) {
        this.f1428b = t0Var;
        this.a = runnable;
    }

    @Override // b.i.a.f.h.j.d0
    public final void a(Throwable th) {
        this.f1428b.f1427b.post(this.a);
    }
}
