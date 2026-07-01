package d0.w;

import d0.Result2;
import d0.w.h.IntrinsicsJvm;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: d0.w.e, reason: use source file name */
/* JADX INFO: compiled from: Continuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Continuation2 {
    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics3.checkNotNullParameter(function2, "$this$startCoroutine");
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        Continuation continuationIntercepted = IntrinsicsJvm.intercepted(IntrinsicsJvm.createCoroutineUnintercepted(function2, r, continuation));
        Unit unit = Unit.a;
        Result2.a aVar = Result2.j;
        continuationIntercepted.resumeWith(Result2.m97constructorimpl(unit));
    }
}
