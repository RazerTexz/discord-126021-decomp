package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v8 implements s8 {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Boolean> f1499b;
    public static final l2<Boolean> c;
    public static final l2<Long> d;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.client.consent_state_v1", false);
        f1499b = q2Var.c("measurement.client.3p_consent_state_v1", false);
        c = q2Var.c("measurement.service.consent_state_v1_W36", false);
        q2Var.a("measurement.id.service.consent_state_v1_W36", 0L);
        d = q2Var.a("measurement.service.storage_consent_support_version", 203590L);
    }

    @Override // b.i.a.f.h.l.s8
    public final boolean a() {
        return true;
    }

    @Override // b.i.a.f.h.l.s8
    public final boolean b() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.s8
    public final boolean c() {
        return f1499b.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.s8
    public final boolean d() {
        return c.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.s8
    public final long e() {
        return d.d().longValue();
    }
}
