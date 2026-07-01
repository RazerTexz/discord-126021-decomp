package s.a.a;

/* JADX INFO: compiled from: StackTraceRecovery.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public static final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3831b;

    static {
        Object objM97constructorimpl;
        Object objM97constructorimpl2;
        try {
            d0.k$a k_a = d0.k.j;
            objM97constructorimpl = d0.k.m97constructorimpl(Class.forName("d0.w.i.a.a").getCanonicalName());
        } catch (Throwable th) {
            d0.k$a k_a2 = d0.k.j;
            objM97constructorimpl = d0.k.m97constructorimpl(d0.l.createFailure(th));
        }
        if (d0.k.m99exceptionOrNullimpl(objM97constructorimpl) != null) {
            objM97constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) objM97constructorimpl;
        try {
            d0.k$a k_a3 = d0.k.j;
            objM97constructorimpl2 = d0.k.m97constructorimpl(Class.forName("s.a.a.s").getCanonicalName());
        } catch (Throwable th2) {
            d0.k$a k_a4 = d0.k.j;
            objM97constructorimpl2 = d0.k.m97constructorimpl(d0.l.createFailure(th2));
        }
        if (d0.k.m99exceptionOrNullimpl(objM97constructorimpl2) != null) {
            objM97constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f3831b = (String) objM97constructorimpl2;
    }
}
