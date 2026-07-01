package d0;

import d0.x.PlatformImplementations2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.b, reason: use source file name */
/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Exceptions {
    public static final void addSuppressed(Throwable th, Throwable th2) {
        Intrinsics3.checkNotNullParameter(th, "$this$addSuppressed");
        Intrinsics3.checkNotNullParameter(th2, "exception");
        if (th != th2) {
            PlatformImplementations2.a.addSuppressed(th, th2);
        }
    }
}
