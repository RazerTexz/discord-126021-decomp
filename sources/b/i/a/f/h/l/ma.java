package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ma implements na {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Boolean> f1460b;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        q2Var.a("measurement.id.lifecycle.app_in_background_parameter", 0L);
        a = q2Var.c("measurement.lifecycle.app_backgrounded_engagement", false);
        q2Var.c("measurement.lifecycle.app_backgrounded_tracking", true);
        f1460b = q2Var.c("measurement.lifecycle.app_in_background_parameter", false);
        q2Var.a("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }

    @Override // b.i.a.f.h.l.na
    public final boolean a() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.na
    public final boolean b() {
        return f1460b.d().booleanValue();
    }
}
