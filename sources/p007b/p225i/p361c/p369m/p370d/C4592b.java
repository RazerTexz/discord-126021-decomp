package p007b.p225i.p361c.p369m.p370d;

import android.util.Log;

/* JADX INFO: renamed from: b.i.c.m.d.b */
/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4592b {

    /* JADX INFO: renamed from: a */
    public static final C4592b f12227a = new C4592b("FirebaseCrashlytics");

    public C4592b(String str) {
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6370a(int i) {
        return 4 <= i || Log.isLoggable("FirebaseCrashlytics", i);
    }

    /* JADX INFO: renamed from: b */
    public void m6371b(String str) {
        if (m6370a(3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m6372c(String str, Throwable th) {
        if (m6370a(3)) {
            Log.d("FirebaseCrashlytics", str, th);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m6373d(String str) {
        if (m6370a(6)) {
            Log.e("FirebaseCrashlytics", str, null);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m6374e(String str, Throwable th) {
        if (m6370a(6)) {
            Log.e("FirebaseCrashlytics", str, th);
        }
    }

    /* JADX INFO: renamed from: f */
    public void m6375f(String str) {
        if (m6370a(4)) {
            Log.i("FirebaseCrashlytics", str, null);
        }
    }

    /* JADX INFO: renamed from: g */
    public void m6376g(String str) {
        if (m6370a(5)) {
            Log.w("FirebaseCrashlytics", str, null);
        }
    }
}
