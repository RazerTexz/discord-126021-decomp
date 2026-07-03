package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.ma */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3753ma implements InterfaceC3766na {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10099a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Boolean> f10100b;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        c3797q2.m5182a("measurement.id.lifecycle.app_in_background_parameter", 0L);
        f10099a = c3797q2.m5184c("measurement.lifecycle.app_backgrounded_engagement", false);
        c3797q2.m5184c("measurement.lifecycle.app_backgrounded_tracking", true);
        f10100b = c3797q2.m5184c("measurement.lifecycle.app_in_background_parameter", false);
        c3797q2.m5182a("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3766na
    /* JADX INFO: renamed from: a */
    public final boolean mo5107a() {
        return f10099a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3766na
    /* JADX INFO: renamed from: b */
    public final boolean mo5108b() {
        return f10100b.m5050d().booleanValue();
    }
}
