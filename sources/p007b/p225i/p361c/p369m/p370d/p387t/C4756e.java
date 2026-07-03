package p007b.p225i.p361c.p369m.p370d.p387t;

/* JADX INFO: renamed from: b.i.c.m.d.t.e */
/* JADX INFO: compiled from: TrimmedThrowableData.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4756e {

    /* JADX INFO: renamed from: a */
    public final String f12777a;

    /* JADX INFO: renamed from: b */
    public final String f12778b;

    /* JADX INFO: renamed from: c */
    public final StackTraceElement[] f12779c;

    /* JADX INFO: renamed from: d */
    public final C4756e f12780d;

    public C4756e(Throwable th, InterfaceC4755d interfaceC4755d) {
        this.f12777a = th.getLocalizedMessage();
        this.f12778b = th.getClass().getName();
        this.f12779c = interfaceC4755d.mo6696a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f12780d = cause != null ? new C4756e(cause, interfaceC4755d) : null;
    }
}
