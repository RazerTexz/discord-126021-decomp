package b.i.c.m.d;

import android.util.Log;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final b a = new b("FirebaseCrashlytics");

    public b(String str) {
    }

    public final boolean a(int i) {
        return 4 <= i || Log.isLoggable("FirebaseCrashlytics", i);
    }

    public void b(String str) {
        if (a(3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d("FirebaseCrashlytics", str, th);
        }
    }

    public void d(String str) {
        if (a(6)) {
            Log.e("FirebaseCrashlytics", str, null);
        }
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e("FirebaseCrashlytics", str, th);
        }
    }

    public void f(String str) {
        if (a(4)) {
            Log.i("FirebaseCrashlytics", str, null);
        }
    }

    public void g(String str) {
        if (a(5)) {
            Log.w("FirebaseCrashlytics", str, null);
        }
    }
}
