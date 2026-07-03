package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.j8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3712j8 implements InterfaceC3670g8 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10042a;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10042a = c3797q2.m5184c("measurement.service.directly_maybe_log_error_events", false);
        c3797q2.m5182a("measurement.id.service.directly_maybe_log_error_events", 0L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3670g8
    /* JADX INFO: renamed from: a */
    public final boolean mo4916a() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3670g8
    /* JADX INFO: renamed from: b */
    public final boolean mo4917b() {
        return f10042a.m5050d().booleanValue();
    }
}
