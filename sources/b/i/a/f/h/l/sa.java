package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class sa implements ta {
    public static final l2<Long> a;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        q2Var.a("measurement.id.max_bundles_per_iteration", 0L);
        a = q2Var.a("measurement.max_bundles_per_iteration", 2L);
    }

    @Override // b.i.a.f.h.l.ta
    public final long a() {
        return a.d().longValue();
    }
}
