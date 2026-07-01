package s.a;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i1 {
    public static final s.a.a.t a = new s.a.a.t("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s.a.a.t f3841b = new s.a.a.t("COMPLETING_WAITING_CHILDREN");
    public static final s.a.a.t c = new s.a.a.t("COMPLETING_RETRY");
    public static final s.a.a.t d = new s.a.a.t("TOO_LATE_TO_CANCEL");
    public static final s.a.a.t e = new s.a.a.t("SEALED");
    public static final p0 f = new p0(false);
    public static final p0 g = new p0(true);

    public static final Object a(Object obj) {
        z0 z0Var;
        a1 a1Var = (a1) (!(obj instanceof a1) ? null : obj);
        return (a1Var == null || (z0Var = a1Var.a) == null) ? obj : z0Var;
    }
}
