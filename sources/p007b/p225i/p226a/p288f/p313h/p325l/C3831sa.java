package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.sa */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3831sa implements InterfaceC3844ta {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Long> f10319a;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        c3797q2.m5182a("measurement.id.max_bundles_per_iteration", 0L);
        f10319a = c3797q2.m5182a("measurement.max_bundles_per_iteration", 2L);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3844ta
    /* JADX INFO: renamed from: a */
    public final long mo5266a() {
        return f10319a.m5050d().longValue();
    }
}
