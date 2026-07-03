package p007b.p225i.p361c.p369m.p370d.p373k;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p384s.InterfaceC4736d;

/* JADX INFO: renamed from: b.i.c.m.d.k.p0 */
/* JADX INFO: compiled from: CrashlyticsUncaughtExceptionHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4648p0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a */
    public final a f12365a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC4736d f12366b;

    /* JADX INFO: renamed from: c */
    public final Thread.UncaughtExceptionHandler f12367c;

    /* JADX INFO: renamed from: d */
    public final AtomicBoolean f12368d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b.i.c.m.d.k.p0$a */
    /* JADX INFO: compiled from: CrashlyticsUncaughtExceptionHandler.java */
    public interface a {
    }

    public C4648p0(a aVar, InterfaceC4736d interfaceC4736d, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f12365a = aVar;
        this.f12366b = interfaceC4736d;
        this.f12367c = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.f12368d.set(true);
        try {
            if (thread == null) {
                C4592b.f12227a.m6373d("Could not handle uncaught exception; null thread");
            } else if (th == null) {
                C4592b.f12227a.m6373d("Could not handle uncaught exception; null throwable");
            } else {
                ((C4611b0) this.f12365a).m6395a(this.f12366b, thread, th);
            }
            C4592b.f12227a.m6371b("Crashlytics completed exception processing. Invoking default exception handler.");
        } catch (Exception e) {
            C4592b c4592b = C4592b.f12227a;
            if (c4592b.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "An error occurred in the uncaught exception handler", e);
            }
            c4592b.m6371b("Crashlytics completed exception processing. Invoking default exception handler.");
        } finally {
            C4592b.f12227a.m6371b("Crashlytics completed exception processing. Invoking default exception handler.");
            this.f12367c.uncaughtException(thread, th);
            this.f12368d.set(false);
        }
    }
}
