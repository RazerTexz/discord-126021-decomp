package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.i9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3699i9 implements InterfaceC3713j9 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10012a;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10012a = c3797q2.m5184c("measurement.sdk.referrer.delayed_install_referrer_api", false);
        c3797q2.m5182a("measurement.id.sdk.referrer.delayed_install_referrer_api", 0L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3713j9
    /* JADX INFO: renamed from: a */
    public final boolean mo4962a() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3713j9
    /* JADX INFO: renamed from: b */
    public final boolean mo4963b() {
        return f10012a.m5050d().booleanValue();
    }
}
