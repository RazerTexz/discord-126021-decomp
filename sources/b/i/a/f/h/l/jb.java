package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class jb implements gb {
    public static final l2<Boolean> a;

    static {
        q2 q2Var = new q2(i2.a("com.google.android.gms.measurement"));
        a = q2Var.c("measurement.service.ssaid_removal", true);
        q2Var.a("measurement.id.ssaid_removal", 0L);
    }

    @Override // b.i.a.f.h.l.gb
    public final boolean a() {
        return true;
    }

    @Override // b.i.a.f.h.l.gb
    public final boolean b() {
        return a.d().booleanValue();
    }
}
