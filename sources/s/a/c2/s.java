package s.a.c2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface s<E> {
    boolean j(Throwable th);

    void l(Function1<? super Throwable, Unit> function1);

    Object o(E e, Continuation<? super Unit> continuation);

    boolean offer(E e);

    boolean p();
}
