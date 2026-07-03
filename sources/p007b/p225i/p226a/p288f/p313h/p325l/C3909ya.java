package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.ya */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3909ya implements InterfaceC3922za {

    /* JADX INFO: renamed from: a */
    public static final AbstractC3732l2<Boolean> f10433a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC3732l2<Double> f10434b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC3732l2<Long> f10435c;

    /* JADX INFO: renamed from: d */
    public static final AbstractC3732l2<Long> f10436d;

    /* JADX INFO: renamed from: e */
    public static final AbstractC3732l2<String> f10437e;

    static {
        C3797q2 c3797q2 = new C3797q2(C3692i2.m4961a("com.google.android.gms.measurement"));
        f10433a = c3797q2.m5184c("measurement.test.boolean_flag", false);
        Object obj = AbstractC3732l2.f10069a;
        f10434b = new C3771o2(c3797q2, "measurement.test.double_flag", Double.valueOf(-3.0d));
        f10435c = c3797q2.m5182a("measurement.test.int_flag", -2L);
        f10436d = c3797q2.m5182a("measurement.test.long_flag", -1L);
        f10437e = c3797q2.m5183b("measurement.test.string_flag", "---");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3922za
    /* JADX INFO: renamed from: a */
    public final boolean mo5384a() {
        return f10433a.m5050d().booleanValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3922za
    /* JADX INFO: renamed from: b */
    public final double mo5385b() {
        return f10434b.m5050d().doubleValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3922za
    /* JADX INFO: renamed from: c */
    public final long mo5386c() {
        return f10435c.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3922za
    /* JADX INFO: renamed from: d */
    public final long mo5387d() {
        return f10436d.m5050d().longValue();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3922za
    /* JADX INFO: renamed from: e */
    public final String mo5388e() {
        return f10437e.m5050d();
    }
}
