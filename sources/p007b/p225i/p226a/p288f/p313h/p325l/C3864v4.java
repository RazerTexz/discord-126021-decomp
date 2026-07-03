package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.v4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3864v4 implements InterfaceC3917z5 {

    /* JADX INFO: renamed from: a */
    public static final C3864v4 f10363a = new C3864v4();

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3917z5
    /* JADX INFO: renamed from: a */
    public final boolean mo5201a(Class<?> cls) {
        return AbstractC3851u4.class.isAssignableFrom(cls);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3917z5
    /* JADX INFO: renamed from: b */
    public final InterfaceC3584a6 mo5202b(Class<?> cls) {
        if (!AbstractC3851u4.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (InterfaceC3584a6) AbstractC3851u4.m5309m(cls.asSubclass(AbstractC3851u4.class)).mo4541p(3, null, null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
