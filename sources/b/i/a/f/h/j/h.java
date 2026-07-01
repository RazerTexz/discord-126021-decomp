package b.i.a.f.h.j;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Thread$UncaughtExceptionHandler {
    public final /* synthetic */ g a;

    public h(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        m0 m0Var = this.a.f;
        if (m0Var != null) {
            m0Var.A("Job execution failed", th);
        }
    }
}
