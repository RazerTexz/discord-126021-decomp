package j0.l.a;

import j0.l.b.SingleProducer;
import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.r1, reason: use source file name */
/* JADX INFO: compiled from: OperatorSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorSingle<T> implements Observable.b<T, T> {

    /* JADX INFO: renamed from: j0.l.a.r1$a */
    /* JADX INFO: compiled from: OperatorSingle.java */
    public static final class a {
        public static final OperatorSingle<?> a = new OperatorSingle<>();
    }

    /* JADX INFO: renamed from: j0.l.a.r1$b */
    /* JADX INFO: compiled from: OperatorSingle.java */
    public static final class b<T> extends Subscriber<T> {
        public final Subscriber<? super T> j;
        public final boolean k;
        public final T l;
        public T m;
        public boolean n;
        public boolean o;

        public b(Subscriber<? super T> subscriber, boolean z2, T t) {
            this.j = subscriber;
            this.k = z2;
            this.l = t;
            request(2L);
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (this.o) {
                return;
            }
            if (this.n) {
                this.j.setProducer(new SingleProducer(this.j, this.m));
            } else if (this.k) {
                this.j.setProducer(new SingleProducer(this.j, this.l));
            } else {
                this.j.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (this.o) {
                j0.o.l.b(th);
            } else {
                this.j.onError(th);
            }
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            if (this.o) {
                return;
            }
            if (!this.n) {
                this.m = t;
                this.n = true;
            } else {
                this.o = true;
                this.j.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
            }
        }
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        b bVar = new b(subscriber, false, null);
        subscriber.add(bVar);
        return bVar;
    }
}
