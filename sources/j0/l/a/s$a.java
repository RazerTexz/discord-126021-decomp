package j0.l.a;

import rx.Producer;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: OnSubscribeMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s$a<T, R> extends Subscriber<T> {
    public final Subscriber<? super R> j;
    public final j0.k.b<? super T, ? extends R> k;
    public boolean l;

    public s$a(Subscriber<? super R> subscriber, j0.k.b<? super T, ? extends R> bVar) {
        this.j = subscriber;
        this.k = bVar;
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
            this.j.onNext(this.k.call(t));
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            unsubscribe();
            onError(OnErrorThrowable.a(th, t));
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.j.setProducer(producer);
    }
}
