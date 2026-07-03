package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.r5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3813r5 implements InterfaceC3917z5 {

    /* JADX INFO: renamed from: a */
    public InterfaceC3917z5[] f10287a;

    public C3813r5(InterfaceC3917z5... interfaceC3917z5Arr) {
        this.f10287a = interfaceC3917z5Arr;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3917z5
    /* JADX INFO: renamed from: a */
    public final boolean mo5201a(Class<?> cls) {
        for (InterfaceC3917z5 interfaceC3917z5 : this.f10287a) {
            if (interfaceC3917z5.mo5201a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3917z5
    /* JADX INFO: renamed from: b */
    public final InterfaceC3584a6 mo5202b(Class<?> cls) {
        for (InterfaceC3917z5 interfaceC3917z5 : this.f10287a) {
            if (interfaceC3917z5.mo5201a(cls)) {
                return interfaceC3917z5.mo5202b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
