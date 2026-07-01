package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class z9 implements w9 {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Boolean> f1506b;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        f1506b = q2Var.c("measurement.collection.redundant_engagement_removal_enabled", false);
        q2Var.a("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }

    @Override // b.i.a.f.h.l.w9
    public final boolean a() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.w9
    public final boolean b() {
        return f1506b.d().booleanValue();
    }
}
