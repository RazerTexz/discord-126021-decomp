package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i9 implements j9 {
    public static final l2<Boolean> a;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.sdk.referrer.delayed_install_referrer_api", false);
        q2Var.a("measurement.id.sdk.referrer.delayed_install_referrer_api", 0L);
    }

    @Override // b.i.a.f.h.l.j9
    public final boolean a() {
        return true;
    }

    @Override // b.i.a.f.h.l.j9
    public final boolean b() {
        return a.d().booleanValue();
    }
}
