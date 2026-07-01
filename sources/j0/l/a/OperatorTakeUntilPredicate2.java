package j0.l.a;

import j0.k.Func1;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.h2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorTakeUntilPredicate2<T> implements Observable.b<T, T> {
    public final Func1<? super T, Boolean> j;

    /* JADX INFO: renamed from: j0.l.a.h2$a */
    /* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
    public final class a extends Subscriber<T> {
        public final Subscriber<? super T> j;
        public boolean k;

        public a(Subscriber<? super T> subscriber) {
            this.j = subscriber;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (this.k) {
                return;
            }
            this.j.onCompleted();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (this.k) {
                return;
            }
            this.j.onError(th);
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            this.j.onNext(t);
            try {
                if (OperatorTakeUntilPredicate2.this.j.call(t).booleanValue()) {
                    this.k = true;
                    this.j.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.k = true;
                b.i.a.f.e.o.f.p1(th, this.j, t);
                unsubscribe();
            }
        }
    }

    public OperatorTakeUntilPredicate2(Func1<? super T, Boolean> func1) {
        this.j = func1;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber);
        subscriber.add(aVar);
        subscriber.setProducer(new OperatorTakeUntilPredicate(this, aVar));
        return aVar;
    }
}
