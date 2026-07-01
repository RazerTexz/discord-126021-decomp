package s.a;

import s.a.a.Symbol3;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i1 {
    public static final Symbol3 a = new Symbol3("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Symbol3 f3841b = new Symbol3("COMPLETING_WAITING_CHILDREN");
    public static final Symbol3 c = new Symbol3("COMPLETING_RETRY");
    public static final Symbol3 d = new Symbol3("TOO_LATE_TO_CANCEL");
    public static final Symbol3 e = new Symbol3("SEALED");
    public static final p0 f = new p0(false);
    public static final p0 g = new p0(true);

    public static final Object a(Object obj) {
        z0 z0Var;
        a1 a1Var = (a1) (!(obj instanceof a1) ? null : obj);
        return (a1Var == null || (z0Var = a1Var.a) == null) ? obj : z0Var;
    }
}
