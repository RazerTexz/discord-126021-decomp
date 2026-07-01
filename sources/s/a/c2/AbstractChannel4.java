package s.a.c2;

import b.d.b.a.outline;
import kotlinx.coroutines.channels.Channel2;
import kotlinx.coroutines.channels.Channel3;
import s.a.CancellableContinuationImpl6;
import s.a.a.LockFreeLinkedList3;
import s.a.a.Symbol3;

/* JADX INFO: renamed from: s.a.c2.i, reason: use source file name */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AbstractChannel4<E> extends AbstractChannel7 implements AbstractChannel6<E> {
    public final Throwable m;

    public AbstractChannel4(Throwable th) {
        this.m = th;
    }

    @Override // s.a.c2.AbstractChannel6
    public Object b() {
        return this;
    }

    @Override // s.a.c2.AbstractChannel6
    public void c(E e) {
    }

    @Override // s.a.c2.AbstractChannel6
    public Symbol3 d(E e, LockFreeLinkedList3.b bVar) {
        return CancellableContinuationImpl6.a;
    }

    @Override // s.a.c2.AbstractChannel7
    public void q() {
    }

    @Override // s.a.c2.AbstractChannel7
    public Object r() {
        return this;
    }

    @Override // s.a.c2.AbstractChannel7
    public void s(AbstractChannel4<?> abstractChannel4) {
    }

    @Override // s.a.c2.AbstractChannel7
    public Symbol3 t(LockFreeLinkedList3.b bVar) {
        return CancellableContinuationImpl6.a;
    }

    @Override // s.a.a.LockFreeLinkedList3
    public String toString() {
        StringBuilder sbU = outline.U("Closed@");
        sbU.append(b.i.a.f.e.o.f.l0(this));
        sbU.append('[');
        sbU.append(this.m);
        sbU.append(']');
        return sbU.toString();
    }

    public final Throwable v() {
        Throwable th = this.m;
        return th != null ? th : new Channel2("Channel was closed");
    }

    public final Throwable w() {
        Throwable th = this.m;
        return th != null ? th : new Channel3("Channel was closed");
    }
}
