package d0.w;

import d0.k;
import d0.k$a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Continuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        m.checkNotNullParameter(function2, "$this$startCoroutine");
        m.checkNotNullParameter(continuation, "completion");
        Continuation continuationIntercepted = d0.w.h.b.intercepted(d0.w.h.b.createCoroutineUnintercepted(function2, r, continuation));
        Unit unit = Unit.a;
        k$a k_a = k.j;
        continuationIntercepted.resumeWith(k.m97constructorimpl(unit));
    }
}
