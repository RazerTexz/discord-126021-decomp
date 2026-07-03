package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.h9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3685h9 implements InterfaceC3643e9 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f9997a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Boolean> f9998b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC3732l2<Boolean> f9999c;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        c3797q2.m5184c("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f9997a = c3797q2.m5184c("measurement.audience.refresh_event_count_filters_timestamp", false);
        f9998b = c3797q2.m5184c("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f9999c = c3797q2.m5184c("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3643e9
    /* JADX INFO: renamed from: a */
    public final boolean mo4868a() {
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3643e9
    /* JADX INFO: renamed from: b */
    public final boolean mo4869b() {
        return f9997a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3643e9
    /* JADX INFO: renamed from: c */
    public final boolean mo4870c() {
        return f9998b.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3643e9
    /* JADX INFO: renamed from: d */
    public final boolean mo4871d() {
        return f9999c.m5050d().booleanValue();
    }
}
