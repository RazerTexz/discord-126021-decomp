package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ga implements ha {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Boolean> f1445b;
    public static final l2<Boolean> c;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.client.global_params", true);
        f1445b = q2Var.c("measurement.service.global_params_in_payload", true);
        c = q2Var.c("measurement.service.global_params", true);
        q2Var.a("measurement.id.service.global_params", 0L);
    }

    @Override // b.i.a.f.h.l.ha
    public final boolean a() {
        return true;
    }

    @Override // b.i.a.f.h.l.ha
    public final boolean b() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.ha
    public final boolean c() {
        return f1445b.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.ha
    public final boolean d() {
        return c.d().booleanValue();
    }
}
