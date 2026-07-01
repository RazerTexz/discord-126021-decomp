package s.a.d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c<T> extends s.a.d2.g.a<T> {
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> d;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineContext coroutineContext, int i, s.a.c2.e eVar) {
        super(coroutineContext, i, eVar);
        this.d = function2;
    }

    @Override // s.a.d2.g.a
    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("block[");
        sbU.append(this.d);
        sbU.append("] -> ");
        sbU.append(super.toString());
        return sbU.toString();
    }
}
