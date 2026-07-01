package b.i.c.m.d.k;

import android.util.Log;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.s.SettingsDataProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b.i.c.m.d.k.p0, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsUncaughtExceptionHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SettingsDataProvider f1692b;
    public final Thread.UncaughtExceptionHandler c;
    public final AtomicBoolean d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b.i.c.m.d.k.p0$a */
    /* JADX INFO: compiled from: CrashlyticsUncaughtExceptionHandler.java */
    public interface a {
    }

    public CrashlyticsUncaughtExceptionHandler(a aVar, SettingsDataProvider settingsDataProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = aVar;
        this.f1692b = settingsDataProvider;
        this.c = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.d.set(true);
        try {
            if (thread == null) {
                Logger3.a.d("Could not handle uncaught exception; null thread");
            } else if (th == null) {
                Logger3.a.d("Could not handle uncaught exception; null throwable");
            } else {
                ((b0) this.a).a(this.f1692b, thread, th);
            }
            Logger3.a.b("Crashlytics completed exception processing. Invoking default exception handler.");
        } catch (Exception e) {
            Logger3 logger3 = Logger3.a;
            if (logger3.a(6)) {
                Log.e("FirebaseCrashlytics", "An error occurred in the uncaught exception handler", e);
            }
            logger3.b("Crashlytics completed exception processing. Invoking default exception handler.");
        } finally {
            Logger3.a.b("Crashlytics completed exception processing. Invoking default exception handler.");
            this.c.uncaughtException(thread, th);
            this.d.set(false);
        }
    }
}
