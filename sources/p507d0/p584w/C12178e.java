package p507d0.p584w;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import p507d0.C12112k;
import p507d0.p584w.p585h.C12182b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.e */
/* JADX INFO: compiled from: Continuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12178e {
    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        C12238m.checkNotNullParameter(function2, "$this$startCoroutine");
        C12238m.checkNotNullParameter(continuation, "completion");
        Continuation continuationIntercepted = C12182b.intercepted(C12182b.createCoroutineUnintercepted(function2, r, continuation));
        Unit unit = Unit.f27425a;
        C12112k.a aVar = C12112k.f25169j;
        continuationIntercepted.resumeWith(C12112k.m11474constructorimpl(unit));
    }
}
