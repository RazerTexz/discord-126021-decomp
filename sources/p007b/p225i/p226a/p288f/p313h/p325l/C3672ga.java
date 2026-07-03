package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.ga */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3672ga implements InterfaceC3686ha {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f9976a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Boolean> f9977b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC3732l2<Boolean> f9978c;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f9976a = c3797q2.m5184c("measurement.client.global_params", true);
        f9977b = c3797q2.m5184c("measurement.service.global_params_in_payload", true);
        f9978c = c3797q2.m5184c("measurement.service.global_params", true);
        c3797q2.m5182a("measurement.id.service.global_params", 0L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3686ha
    /* JADX INFO: renamed from: a */
    public final boolean mo4918a() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3686ha
    /* JADX INFO: renamed from: b */
    public final boolean mo4919b() {
        return f9976a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3686ha
    /* JADX INFO: renamed from: c */
    public final boolean mo4920c() {
        return f9977b.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3686ha
    /* JADX INFO: renamed from: d */
    public final boolean mo4921d() {
        return f9978c.m5050d().booleanValue();
    }
}
