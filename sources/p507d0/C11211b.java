package p507d0;

import p507d0.p588x.C12196b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.b */
/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11211b {
    public static final void addSuppressed(Throwable th, Throwable th2) {
        C12238m.checkNotNullParameter(th, "$this$addSuppressed");
        C12238m.checkNotNullParameter(th2, "exception");
        if (th != th2) {
            C12196b.f25252a.addSuppressed(th, th2);
        }
    }
}
