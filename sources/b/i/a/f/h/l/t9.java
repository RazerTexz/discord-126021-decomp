package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t9 implements q9 {
    public static final l2<Boolean> a;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.client.sessions.check_on_reset_and_enable2", true);
        q2Var.c("measurement.client.sessions.check_on_startup", true);
        q2Var.c("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // b.i.a.f.h.l.q9
    public final boolean a() {
        return true;
    }

    @Override // b.i.a.f.h.l.q9
    public final boolean b() {
        return a.d().booleanValue();
    }
}
