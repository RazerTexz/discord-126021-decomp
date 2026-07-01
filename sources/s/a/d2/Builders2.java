package s.a.d2;

import b.d.b.a.outline;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Produce;
import s.a.c2.BufferOverflow;
import s.a.d2.g.ChannelFlow;

/* JADX INFO: renamed from: s.a.d2.c, reason: use source file name */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Builders2<T> extends ChannelFlow<T> {
    public final Function2<Produce<? super T>, Continuation<? super Unit>, Object> d;

    /* JADX WARN: Multi-variable type inference failed */
    public Builders2(Function2<? super Produce<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.d = function2;
    }

    @Override // s.a.d2.g.ChannelFlow
    public String toString() {
        StringBuilder sbU = outline.U("block[");
        sbU.append(this.d);
        sbU.append("] -> ");
        sbU.append(super.toString());
        return sbU.toString();
    }
}
