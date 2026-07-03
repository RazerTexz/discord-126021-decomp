package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.z9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3921z9 implements InterfaceC3882w9 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10443a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Boolean> f10444b;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10443a = c3797q2.m5184c("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        f10444b = c3797q2.m5184c("measurement.collection.redundant_engagement_removal_enabled", false);
        c3797q2.m5182a("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3882w9
    /* JADX INFO: renamed from: a */
    public final boolean mo5352a() {
        return f10443a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3882w9
    /* JADX INFO: renamed from: b */
    public final boolean mo5353b() {
        return f10444b.m5050d().booleanValue();
    }
}
