package p659s.p660a.p663c2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: s.a.c2.s */
/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC13072s<E> {
    /* JADX INFO: renamed from: j */
    boolean mo11221j(Throwable th);

    /* JADX INFO: renamed from: l */
    void mo11223l(Function1<? super Throwable, Unit> function1);

    /* JADX INFO: renamed from: o */
    Object mo11224o(E e, Continuation<? super Unit> continuation);

    boolean offer(E e);

    /* JADX INFO: renamed from: p */
    boolean mo11225p();
}
