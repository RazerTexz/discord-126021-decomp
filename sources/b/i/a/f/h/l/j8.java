package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j8 implements g8 {
    public static final l2<Boolean> a;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.service.directly_maybe_log_error_events", false);
        q2Var.a("measurement.id.service.directly_maybe_log_error_events", 0L);
    }

    @Override // b.i.a.f.h.l.g8
    public final boolean a() {
        return true;
    }

    @Override // b.i.a.f.h.l.g8
    public final boolean b() {
        return a.d().booleanValue();
    }
}
