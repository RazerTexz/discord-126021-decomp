package d0;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final void addSuppressed(Throwable th, Throwable th2) {
        d0.z.d.m.checkNotNullParameter(th, "$this$addSuppressed");
        d0.z.d.m.checkNotNullParameter(th2, "exception");
        if (th != th2) {
            d0.x.b.a.addSuppressed(th, th2);
        }
    }
}
