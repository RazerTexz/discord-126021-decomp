package b.i.c.m.d.t;

/* JADX INFO: renamed from: b.i.c.m.d.t.e, reason: use source file name */
/* JADX INFO: compiled from: TrimmedThrowableData.java */
/* JADX INFO: loaded from: classes3.dex */
public class TrimmedThrowableData {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1753b;
    public final StackTraceElement[] c;
    public final TrimmedThrowableData d;

    public TrimmedThrowableData(Throwable th, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.a = th.getLocalizedMessage();
        this.f1753b = th.getClass().getName();
        this.c = stackTraceTrimmingStrategy.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.d = cause != null ? new TrimmedThrowableData(cause, stackTraceTrimmingStrategy) : null;
    }
}
