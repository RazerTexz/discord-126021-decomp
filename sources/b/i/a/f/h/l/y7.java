package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y7 implements z7 {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Boolean> f1504b;
    public static final l2<Boolean> c;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.client.ad_impression", true);
        f1504b = q2Var.c("measurement.service.separate_public_internal_event_blacklisting", true);
        c = q2Var.c("measurement.service.ad_impression", true);
        q2Var.a("measurement.id.service.ad_impression", 0L);
    }

    @Override // b.i.a.f.h.l.z7
    public final boolean a() {
        return true;
    }

    @Override // b.i.a.f.h.l.z7
    public final boolean b() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.z7
    public final boolean c() {
        return f1504b.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.z7
    public final boolean d() {
        return c.d().booleanValue();
    }
}
