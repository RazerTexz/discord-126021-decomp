package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.c */
/* JADX INFO: compiled from: exceptionUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12035c {
    public static final boolean isProcessCanceledException(Throwable th) {
        C12238m.checkNotNullParameter(th, "<this>");
        Class<?> superclass = th.getClass();
        while (!C12238m.areEqual(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException rethrow(Throwable th) throws Throwable {
        C12238m.checkNotNullParameter(th, "e");
        throw th;
    }
}
