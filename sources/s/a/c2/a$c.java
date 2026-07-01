package s.a.c2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c<E> extends a$b<E> {
    public final Function1<E, Unit> o;

    /* JADX WARN: Multi-variable type inference failed */
    public a$c(CancellableContinuation<Object> cancellableContinuation, int i, Function1<? super E, Unit> function1) {
        super(cancellableContinuation, i);
        this.o = function1;
    }

    @Override // s.a.c2.n
    public Function1<Throwable, Unit> q(E e) {
        return new s.a.a.o(this.o, e, this.m.getContext());
    }
}
