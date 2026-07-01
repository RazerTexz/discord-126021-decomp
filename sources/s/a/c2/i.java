package s.a.c2;

import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import s.a.a.k$b;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i<E> extends r implements p<E> {
    public final Throwable m;

    public i(Throwable th) {
        this.m = th;
    }

    @Override // s.a.c2.p
    public Object b() {
        return this;
    }

    @Override // s.a.c2.p
    public void c(E e) {
    }

    @Override // s.a.c2.p
    public s.a.a.t d(E e, k$b k_b) {
        return s.a.m.a;
    }

    @Override // s.a.c2.r
    public void q() {
    }

    @Override // s.a.c2.r
    public Object r() {
        return this;
    }

    @Override // s.a.c2.r
    public void s(i<?> iVar) {
    }

    @Override // s.a.c2.r
    public s.a.a.t t(k$b k_b) {
        return s.a.m.a;
    }

    @Override // s.a.a.k
    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Closed@");
        sbU.append(b.i.a.f.e.o.f.l0(this));
        sbU.append('[');
        sbU.append(this.m);
        sbU.append(']');
        return sbU.toString();
    }

    public final Throwable v() {
        Throwable th = this.m;
        return th != null ? th : new ClosedReceiveChannelException("Channel was closed");
    }

    public final Throwable w() {
        Throwable th = this.m;
        return th != null ? th : new ClosedSendChannelException("Channel was closed");
    }
}
