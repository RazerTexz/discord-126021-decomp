package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.k8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3725k8 implements InterfaceC3738l8 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10059a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Long> f10060b;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10059a = c3797q2.m5184c("measurement.sdk.attribution.cache", true);
        f10060b = c3797q2.m5182a("measurement.sdk.attribution.cache.ttl", 604800000L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3738l8
    /* JADX INFO: renamed from: a */
    public final boolean mo5025a() {
        return f10059a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3738l8
    /* JADX INFO: renamed from: b */
    public final long mo5026b() {
        return f10060b.m5050d().longValue();
    }
}
