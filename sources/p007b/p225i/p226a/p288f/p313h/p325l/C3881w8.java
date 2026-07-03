package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.w8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3881w8 implements InterfaceC3894x8 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10392a;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10392a = c3797q2.m5184c("measurement.sdk.dynamite.allow_remote_dynamite3", true);
        c3797q2.m5184c("measurement.collection.init_params_control_enabled", true);
        c3797q2.m5184c("measurement.sdk.dynamite.use_dynamite3", true);
        c3797q2.m5182a("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3894x8
    /* JADX INFO: renamed from: a */
    public final boolean mo5351a() {
        return f10392a.m5050d().booleanValue();
    }
}
