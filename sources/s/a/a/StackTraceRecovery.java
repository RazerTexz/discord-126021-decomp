package s.a.a;

import d0.Result2;
import d0.Result3;

/* JADX INFO: renamed from: s.a.a.s, reason: use source file name */
/* JADX INFO: compiled from: StackTraceRecovery.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StackTraceRecovery {
    public static final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3831b;

    static {
        Object objM97constructorimpl;
        Object objM97constructorimpl2;
        try {
            Result2.a aVar = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Class.forName("d0.w.i.a.a").getCanonicalName());
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
        }
        if (Result2.m99exceptionOrNullimpl(objM97constructorimpl) != null) {
            objM97constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) objM97constructorimpl;
        try {
            Result2.a aVar3 = Result2.j;
            objM97constructorimpl2 = Result2.m97constructorimpl(Class.forName("s.a.a.s").getCanonicalName());
        } catch (Throwable th2) {
            Result2.a aVar4 = Result2.j;
            objM97constructorimpl2 = Result2.m97constructorimpl(Result3.createFailure(th2));
        }
        if (Result2.m99exceptionOrNullimpl(objM97constructorimpl2) != null) {
            objM97constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f3831b = (String) objM97constructorimpl2;
    }
}
