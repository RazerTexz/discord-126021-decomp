package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v4 implements z5 {
    public static final v4 a = new v4();

    @Override // b.i.a.f.h.l.z5
    public final boolean a(Class<?> cls) {
        return u4.class.isAssignableFrom(cls);
    }

    @Override // b.i.a.f.h.l.z5
    public final a6 b(Class<?> cls) {
        if (!u4.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (a6) u4.m(cls.asSubclass(u4.class)).p(3, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
