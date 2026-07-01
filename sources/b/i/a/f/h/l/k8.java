package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k8 implements l8 {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Long> f1455b;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.sdk.attribution.cache", true);
        f1455b = q2Var.a("measurement.sdk.attribution.cache.ttl", 604800000L);
    }

    @Override // b.i.a.f.h.l.l8
    public final boolean a() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.l8
    public final long b() {
        return f1455b.d().longValue();
    }
}
