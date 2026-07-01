package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ya implements za {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Double> f1505b;
    public static final l2<Long> c;
    public static final l2<Long> d;
    public static final l2<String> e;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.test.boolean_flag", false);
        Object obj = l2.a;
        f1505b = new o2(q2Var, "measurement.test.double_flag", Double.valueOf(-3.0d));
        c = q2Var.a("measurement.test.int_flag", -2L);
        d = q2Var.a("measurement.test.long_flag", -1L);
        e = q2Var.b("measurement.test.string_flag", "---");
    }

    @Override // b.i.a.f.h.l.za
    public final boolean a() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.za
    public final double b() {
        return f1505b.d().doubleValue();
    }

    @Override // b.i.a.f.h.l.za
    public final long c() {
        return c.d().longValue();
    }

    @Override // b.i.a.f.h.l.za
    public final long d() {
        return d.d().longValue();
    }

    @Override // b.i.a.f.h.l.za
    public final String e() {
        return e.d();
    }
}
