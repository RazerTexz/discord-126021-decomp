package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.v8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3868v8 implements InterfaceC3829s8 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10364a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Boolean> f10365b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC3732l2<Boolean> f10366c;

    /* JADX INFO: renamed from: d */
    public static final AbstractC3732l2<Long> f10367d;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10364a = c3797q2.m5184c("measurement.client.consent_state_v1", false);
        f10365b = c3797q2.m5184c("measurement.client.3p_consent_state_v1", false);
        f10366c = c3797q2.m5184c("measurement.service.consent_state_v1_W36", false);
        c3797q2.m5182a("measurement.id.service.consent_state_v1_W36", 0L);
        f10367d = c3797q2.m5182a("measurement.service.storage_consent_support_version", 203590L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3829s8
    /* JADX INFO: renamed from: a */
    public final boolean mo5261a() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3829s8
    /* JADX INFO: renamed from: b */
    public final boolean mo5262b() {
        return f10364a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3829s8
    /* JADX INFO: renamed from: c */
    public final boolean mo5263c() {
        return f10365b.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3829s8
    /* JADX INFO: renamed from: d */
    public final boolean mo5264d() {
        return f10366c.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3829s8
    /* JADX INFO: renamed from: e */
    public final long mo5265e() {
        return f10367d.m5050d().longValue();
    }
}
