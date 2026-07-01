package d0.e0.p.d.m0.p;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.c, reason: use source file name */
/* JADX INFO: compiled from: exceptionUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class exceptionUtils {
    public static final boolean isProcessCanceledException(Throwable th) {
        Intrinsics3.checkNotNullParameter(th, "<this>");
        Class<?> superclass = th.getClass();
        while (!Intrinsics3.areEqual(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException rethrow(Throwable th) throws Throwable {
        Intrinsics3.checkNotNullParameter(th, "e");
        throw th;
    }
}
