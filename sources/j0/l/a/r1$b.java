package j0.l.a;

import java.util.NoSuchElementException;
import rx.Subscriber;

/* JADX INFO: compiled from: OperatorSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r1$b<T> extends Subscriber<T> {
    public final Subscriber<? super T> j;
    public final boolean k;
    public final T l;
    public T m;
    public boolean n;
    public boolean o;

    public r1$b(Subscriber<? super T> subscriber, boolean z2, T t) {
        this.j = subscriber;
        this.k = z2;
        this.l = t;
        request(2L);
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.o) {
            return;
        }
        if (this.n) {
            this.j.setProducer(new j0.l.b.c(this.j, this.m));
        } else if (this.k) {
            this.j.setProducer(new j0.l.b.c(this.j, this.l));
        } else {
            this.j.onError(new NoSuchElementException("Sequence contains no elements"));
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.o) {
            j0.o.l.b(th);
        } else {
            this.j.onError(th);
        }
    }

    @Override // j0.g
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
