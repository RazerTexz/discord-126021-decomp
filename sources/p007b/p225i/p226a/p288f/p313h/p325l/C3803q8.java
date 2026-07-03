package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.q8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3803q8 implements InterfaceC3816r8 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10274a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Boolean> f10275b;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10274a = c3797q2.m5184c("measurement.service.configurable_service_limits", true);
        f10275b = c3797q2.m5184c("measurement.client.configurable_service_limits", true);
        c3797q2.m5182a("measurement.id.service.configurable_service_limits", 0L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3816r8
    /* JADX INFO: renamed from: a */
    public final boolean mo5191a() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3816r8
    /* JADX INFO: renamed from: b */
    public final boolean mo5192b() {
        return f10274a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3816r8
    /* JADX INFO: renamed from: c */
    public final boolean mo5193c() {
        return f10275b.m5050d().booleanValue();
    }
}
