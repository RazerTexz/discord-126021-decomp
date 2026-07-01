package j0.l.a;

import rx.Producer;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeConcatMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b<T, R> extends Subscriber<R> {
    public final h$c<T, R> j;
    public long k;

    public h$b(h$c<T, R> h_c) {
        this.j = h_c;
    }

    @Override // j0.g
    public void onCompleted() {
        h$c<T, R> h_c = this.j;
        long j = this.k;
        if (j != 0) {
            h_c.m.b(j);
        }
        h_c.f3773s = false;
        h_c.a();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        h$c<T, R> h_c = this.j;
        long j = this.k;
        if (!j0.l.e.d.f(h_c.p, th)) {
            j0.o.l.b(th);
            return;
        }
        if (h_c.l == 0) {
            Throwable thH = j0.l.e.d.h(h_c.p);
            if (!j0.l.e.d.g(thH)) {
                h_c.j.onError(thH);
            }
            h_c.unsubscribe();
            return;
        }
        if (j != 0) {
            h_c.m.b(j);
        }
        h_c.f3773s = false;
        h_c.a();
    }

    @Override // j0.g
    public void onNext(R r) {
        this.k++;
        this.j.j.onNext(r);
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.j.m.c(producer);
    }
}
