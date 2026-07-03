package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.q3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3798q3 {

    /* JADX INFO: renamed from: a */
    public static final Class<?> f10264a;

    /* JADX INFO: renamed from: b */
    public static final boolean f10265b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f10264a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f10265b = cls2 != null;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m5185a() {
        return (f10264a == null || f10265b) ? false : true;
    }
}
