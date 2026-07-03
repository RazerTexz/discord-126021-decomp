package p507d0;

import p507d0.C12112k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.l */
/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12113l {
    public static final Object createFailure(Throwable th) {
        C12238m.checkNotNullParameter(th, "exception");
        return new C12112k.b(th);
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof C12112k.b) {
            throw ((C12112k.b) obj).exception;
        }
    }
}
