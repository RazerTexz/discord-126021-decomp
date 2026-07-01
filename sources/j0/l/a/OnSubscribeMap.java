package j0.l.a;

import j0.k.Func1;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: renamed from: j0.l.a.s, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeMap<T, R> implements Observable.a<R> {
    public final Observable<T> j;
    public final Func1<? super T, ? extends R> k;

    /* JADX INFO: renamed from: j0.l.a.s$a */
    /* JADX INFO: compiled from: OnSubscribeMap.java */
    public static final class a<T, R> extends Subscriber<T> {
        public final Subscriber<? super R> j;
        public final Func1<? super T, ? extends R> k;
        public boolean l;

        public a(Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
            this.j = subscriber;
            this.k = func1;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (this.l) {
                return;
            }
            this.j.onCompleted();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (this.l) {
                j0.o.l.b(th);
            } else {
                this.l = true;
                this.j.onError(th);
            }
        }

        @Override // j0.Observer2
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

    public OnSubscribeMap(Observable<T> observable, Func1<? super T, ? extends R> func1) {
        this.j = observable;
        this.k = func1;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.k);
        subscriber.add(aVar);
        this.j.i0(aVar);
    }
}
