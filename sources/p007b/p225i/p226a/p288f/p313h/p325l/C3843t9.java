package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.t9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3843t9 implements InterfaceC3804q9 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10328a;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10328a = c3797q2.m5184c("measurement.client.sessions.check_on_reset_and_enable2", true);
        c3797q2.m5184c("measurement.client.sessions.check_on_startup", true);
        c3797q2.m5184c("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3804q9
    /* JADX INFO: renamed from: a */
    public final boolean mo5194a() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3804q9
    /* JADX INFO: renamed from: b */
    public final boolean mo5195b() {
        return f10328a.m5050d().booleanValue();
    }
}
