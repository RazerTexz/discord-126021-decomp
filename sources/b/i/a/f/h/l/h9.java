package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h9 implements e9 {
    public static final l2<Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l2<Boolean> f1449b;
    public static final l2<Boolean> c;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        q2Var.c("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        a = q2Var.c("measurement.audience.refresh_event_count_filters_timestamp", false);
        f1449b = q2Var.c("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        c = q2Var.c("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // b.i.a.f.h.l.e9
    public final boolean a() {
        return true;
    }

    @Override // b.i.a.f.h.l.e9
    public final boolean b() {
        return a.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.e9
    public final boolean c() {
        return f1449b.d().booleanValue();
    }

    @Override // b.i.a.f.h.l.e9
    public final boolean d() {
        return c.d().booleanValue();
    }
}
