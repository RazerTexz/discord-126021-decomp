package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q8 implements r8 {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Boolean> f1489b;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.service.configurable_service_limits", true);
        f1489b = q2Var.c("measurement.client.configurable_service_limits", true);
        q2Var.a("measurement.id.service.configurable_service_limits", 0L);
    }

    @Override // b.i.a.f.h.l.r8
    public final boolean a() {
        return true;
    }

    @Override // b.i.a.f.h.l.r8
    public final boolean b() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.r8
    public final boolean c() {
        return f1489b.d().booleanValue();
    }
}
