package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.m */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3210m {

    /* JADX INFO: renamed from: a */
    @Nullable
    public static C3210m f9238a;

    /* JADX INFO: renamed from: b */
    public C3198a f9239b;

    public C3210m(Context context) {
        C3198a c3198aM3973a = C3198a.m3973a(context);
        this.f9239b = c3198aM3973a;
        c3198aM3973a.m3975b();
        this.f9239b.m3976c();
    }

    /* JADX INFO: renamed from: b */
    public static synchronized C3210m m3990b(@NonNull Context context) {
        C3210m c3210m;
        Context applicationContext = context.getApplicationContext();
        synchronized (C3210m.class) {
            c3210m = f9238a;
            if (c3210m == null) {
                c3210m = new C3210m(applicationContext);
                f9238a = c3210m;
            }
        }
        return c3210m;
        return c3210m;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m3991a() {
        C3198a c3198a = this.f9239b;
        c3198a.f9227c.lock();
        try {
            c3198a.f9228d.edit().clear().apply();
            c3198a.f9227c.unlock();
        } catch (Throwable th) {
            c3198a.f9227c.unlock();
            throw th;
        }
    }
}
