package p007b.p225i.p226a.p288f.p313h.p323j;

import java.lang.Thread;

/* JADX INFO: renamed from: b.i.a.f.h.j.h */
/* JADX INFO: loaded from: classes3.dex */
public final class C3518h implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C3515g f9732a;

    public C3518h(C3515g c3515g) {
        this.f9732a = c3515g;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        C3529m0 c3529m0 = this.f9732a.f9726f;
        if (c3529m0 != null) {
            c3529m0.m4426A("Job execution failed", th);
        }
    }
}
