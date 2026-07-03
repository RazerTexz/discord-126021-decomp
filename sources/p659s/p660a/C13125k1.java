package p659s.p660a;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.p585h.C12182b;

/* JADX INFO: renamed from: s.a.k1 */
/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13125k1 extends C13152t1 {

    /* JADX INFO: renamed from: m */
    public final Continuation<Unit> f27868m;

    public C13125k1(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.f27868m = C12182b.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // p659s.p660a.AbstractC13045b
    /* JADX INFO: renamed from: i0 */
    public void mo11190i0() {
        C3404f.m4285e1(this.f27868m, this);
    }
}
