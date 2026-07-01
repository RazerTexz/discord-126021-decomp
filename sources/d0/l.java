package d0;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static final Object createFailure(Throwable th) {
        d0.z.d.m.checkNotNullParameter(th, "exception");
        return new k$b(th);
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof k$b) {
            throw ((k$b) obj).exception;
        }
    }
}
