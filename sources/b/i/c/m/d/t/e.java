package b.i.c.m.d.t;

/* JADX INFO: compiled from: TrimmedThrowableData.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1753b;
    public final StackTraceElement[] c;
    public final e d;

    public e(Throwable th, d dVar) {
        this.a = th.getLocalizedMessage();
        this.f1753b = th.getClass().getName();
        this.c = dVar.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.d = cause != null ? new e(cause, dVar) : null;
    }
}
