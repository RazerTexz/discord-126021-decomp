package d0.e0.p.d.m0.p;

import d0.z.d.m;

/* JADX INFO: compiled from: exceptionUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final boolean isProcessCanceledException(Throwable th) {
        m.checkNotNullParameter(th, "<this>");
        Class<?> superclass = th.getClass();
        while (!m.areEqual(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException rethrow(Throwable th) throws Throwable {
        m.checkNotNullParameter(th, "e");
        throw th;
    }
}
