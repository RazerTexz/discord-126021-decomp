package j0.l.a;

import rx.Producer;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: OnSubscribeFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l$a<T> extends Subscriber<T> {
    public final Subscriber<? super T> j;
    public final j0.k.b<? super T, Boolean> k;
    public boolean l;

    public l$a(Subscriber<? super T> subscriber, j0.k.b<? super T, Boolean> bVar) {
        this.j = subscriber;
        this.k = bVar;
        request(0L);
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.l) {
            return;
        }
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.l) {
            j0.o.l.b(th);
        } else {
            this.l = true;
            this.j.onError(th);
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        try {
            if (this.k.call(t).booleanValue()) {
                this.j.onNext(t);
            } else {
                request(1L);
            }
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            unsubscribe();
            onError(OnErrorThrowable.a(th, t));
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        super.setProducer(producer);
        this.j.setProducer(producer);
    }
}
