package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.y7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3906y7 implements InterfaceC3919z7 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10428a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Boolean> f10429b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC3732l2<Boolean> f10430c;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10428a = c3797q2.m5184c("measurement.client.ad_impression", true);
        f10429b = c3797q2.m5184c("measurement.service.separate_public_internal_event_blacklisting", true);
        f10430c = c3797q2.m5184c("measurement.service.ad_impression", true);
        c3797q2.m5182a("measurement.id.service.ad_impression", 0L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3919z7
    /* JADX INFO: renamed from: a */
    public final boolean mo5380a() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3919z7
    /* JADX INFO: renamed from: b */
    public final boolean mo5381b() {
        return f10428a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3919z7
    /* JADX INFO: renamed from: c */
    public final boolean mo5382c() {
        return f10429b.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3919z7
    /* JADX INFO: renamed from: d */
    public final boolean mo5383d() {
        return f10430c.m5050d().booleanValue();
    }
}
