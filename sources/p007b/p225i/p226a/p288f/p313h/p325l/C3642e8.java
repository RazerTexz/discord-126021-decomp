package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.e8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3642e8 implements InterfaceC3656f8 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f9931a;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f9931a = c3797q2.m5184c("measurement.androidId.delete_feature", true);
        c3797q2.m5184c("measurement.log_androidId_enabled", false);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3656f8
    /* JADX INFO: renamed from: a */
    public final boolean mo4867a() {
        return f9931a.m5050d().booleanValue();
    }
}
