package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w8 implements x8 {
    public static final l2<Boolean> a;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.sdk.dynamite.allow_remote_dynamite3", true);
        q2Var.c("measurement.collection.init_params_control_enabled", true);
        q2Var.c("measurement.sdk.dynamite.use_dynamite3", true);
        q2Var.a("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }

    @Override // b.i.a.f.h.l.x8
    public final boolean a() {
        return a.d().booleanValue();
    }
}
