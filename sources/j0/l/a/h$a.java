package j0.l.a;

import rx.Producer;

/* JADX INFO: compiled from: OnSubscribeConcatMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a<T, R> implements Producer {
    public final R j;
    public final h$c<T, R> k;
    public boolean l;

    public h$a(R r, h$c<T, R> h_c) {
        this.j = r;
        this.k = h_c;
    }

    @Override // rx.Producer
    public void j(long j) {
        if (this.l || j <= 0) {
            return;
        }
        this.l = true;
        h$c<T, R> h_c = this.k;
        h_c.j.onNext(this.j);
        h_c.m.b(1L);
        h_c.f3773s = false;
        h_c.a();
    }
}
