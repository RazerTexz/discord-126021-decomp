package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e8 implements f8 {
    public static final l2<Boolean> a;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.androidId.delete_feature", true);
        q2Var.c("measurement.log_androidId_enabled", false);
    }

    @Override // b.i.a.f.h.l.f8
    public final boolean a() {
        return a.d().booleanValue();
    }
}
