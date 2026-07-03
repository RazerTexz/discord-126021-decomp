package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.la */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3740la implements InterfaceC3700ia {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10081a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Boolean> f10082b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC3732l2<Boolean> f10083c;

    /* JADX INFO: renamed from: d */
    public static final AbstractC3732l2<Boolean> f10084d;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10081a = c3797q2.m5184c("measurement.sdk.collection.enable_extend_user_property_size", true);
        f10082b = c3797q2.m5184c("measurement.sdk.collection.last_deep_link_referrer2", true);
        f10083c = c3797q2.m5184c("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        f10084d = c3797q2.m5184c("measurement.sdk.collection.last_gclid_from_referrer2", false);
        c3797q2.m5182a("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3700ia
    /* JADX INFO: renamed from: a */
    public final boolean mo4964a() {
        return f10081a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3700ia
    /* JADX INFO: renamed from: b */
    public final boolean mo4965b() {
        return f10082b.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3700ia
    /* JADX INFO: renamed from: c */
    public final boolean mo4966c() {
        return f10083c.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3700ia
    /* JADX INFO: renamed from: d */
    public final boolean mo4967d() {
        return f10084d.m5050d().booleanValue();
    }
}
