package s.a.c2;

import s.a.a.k$b;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a<E> extends r {
    public final E m;

    public c$a(E e) {
        this.m = e;
    }

    @Override // s.a.c2.r
    public void q() {
    }

    @Override // s.a.c2.r
    public Object r() {
        return this.m;
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
        StringBuilder sbU = b.d.b.a.a.U("SendBuffered@");
        sbU.append(b.i.a.f.e.o.f.l0(this));
        sbU.append('(');
        sbU.append(this.m);
        sbU.append(')');
        return sbU.toString();
    }
}
