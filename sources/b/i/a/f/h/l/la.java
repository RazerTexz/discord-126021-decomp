package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class la implements ia {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Boolean> f1457b;
    public static final l2<Boolean> c;
    public static final l2<Boolean> d;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.sdk.collection.enable_extend_user_property_size", true);
        f1457b = q2Var.c("measurement.sdk.collection.last_deep_link_referrer2", true);
        c = q2Var.c("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        d = q2Var.c("measurement.sdk.collection.last_gclid_from_referrer2", false);
        q2Var.a("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // b.i.a.f.h.l.ia
    public final boolean a() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.ia
    public final boolean b() {
        return f1457b.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.ia
    public final boolean c() {
        return c.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.ia
    public final boolean d() {
        return d.d().booleanValue();
    }
}
