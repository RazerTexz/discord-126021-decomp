package d0;

import d0.Result2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.l, reason: use source file name */
/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Result3 {
    public static final Object createFailure(Throwable th) {
        Intrinsics3.checkNotNullParameter(th, "exception");
        return new Result2.b(th);
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof Result2.b) {
            throw ((Result2.b) obj).exception;
        }
    }
}
