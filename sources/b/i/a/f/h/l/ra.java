package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ra implements oa {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Boolean> f1491b;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.sdk.screen.manual_screen_view_logging", true);
        f1491b = q2Var.c("measurement.sdk.screen.disabling_automatic_reporting", true);
    }

    @Override // b.i.a.f.h.l.oa
    public final boolean a() {
        return true;
    }

    @Override // b.i.a.f.h.l.oa
    public final boolean b() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.oa
    public final boolean c() {
        return f1491b.d().booleanValue();
    }
}
