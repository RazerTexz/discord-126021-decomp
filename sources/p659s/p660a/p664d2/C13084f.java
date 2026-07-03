package p659s.p660a.p664d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import p507d0.p584w.p585h.C12183c;

/* JADX INFO: renamed from: s.a.d2.f */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13084f<T> extends AbstractC13079a<T> {

    /* JADX INFO: renamed from: a */
    public final Function2<InterfaceC13083e<? super T>, Continuation<? super Unit>, Object> f27783a;

    /* JADX WARN: Multi-variable type inference failed */
    public C13084f(Function2<? super InterfaceC13083e<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f27783a = function2;
    }

    @Override // p659s.p660a.p664d2.AbstractC13079a
    /* JADX INFO: renamed from: b */
    public Object mo11247b(InterfaceC13083e<? super T> interfaceC13083e, Continuation<? super Unit> continuation) {
        Object objInvoke = this.f27783a.invoke(interfaceC13083e, continuation);
        return objInvoke == C12183c.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.f27425a;
    }
}
