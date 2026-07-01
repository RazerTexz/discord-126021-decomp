package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q3 {
    public static final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f1488b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f1488b = cls2 != null;
    }

    public static boolean a() {
        return (a == null || f1488b) ? false : true;
    }
}
