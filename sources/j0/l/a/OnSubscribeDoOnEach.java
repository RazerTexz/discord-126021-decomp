package j0.l.a;

import j0.Observer2;
import java.util.Arrays;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;

/* JADX INFO: renamed from: j0.l.a.k, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeDoOnEach.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeDoOnEach<T> implements Observable.a<T> {
    public final Observer2<? super T> j;
    public final Observable<T> k;

    /* JADX INFO: renamed from: j0.l.a.k$a */
    /* JADX INFO: compiled from: OnSubscribeDoOnEach.java */
    public static final class a<T> extends Subscriber<T> {
        public final Subscriber<? super T> j;
        public final Observer2<? super T> k;
        public boolean l;

        public a(Subscriber<? super T> subscriber, Observer2<? super T> observer2) {
            super(subscriber);
            this.j = subscriber;
            this.k = observer2;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (this.l) {
                return;
            }
            try {
                this.k.onCompleted();
                this.l = true;
                this.j.onCompleted();
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                onError(th);
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (this.l) {
                j0.o.l.b(th);
                return;
            }
            this.l = true;
            try {
                this.k.onError(th);
                this.j.onError(th);
            } catch (Throwable th2) {
                b.i.a.f.e.o.f.o1(th2);
                this.j.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            if (this.l) {
                return;
            }
            try {
                this.k.onNext(t);
                this.j.onNext(t);
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, this, t);
            }
        }
    }

    public OnSubscribeDoOnEach(Observable<T> observable, Observer2<? super T> observer2) {
        this.k = observable;
        this.j = observer2;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        this.k.i0(new a((Subscriber) obj, this.j));
    }
}
