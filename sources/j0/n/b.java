package j0.n;

import b.i.a.f.e.o.f;
import j0.o.l;
import j0.o.o;
import java.util.Arrays;
import java.util.Objects;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;

/* JADX INFO: compiled from: SafeSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public class b<T> extends Subscriber<T> {
    public final Subscriber<? super T> j;
    public boolean k;

    public b(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.j = subscriber;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.k) {
            return;
        }
        this.k = true;
        try {
            this.j.onCompleted();
            try {
                unsubscribe();
            } catch (Throwable th) {
                l.b(th);
                throw new UnsubscribeFailedException(th.getMessage(), th);
            }
        } catch (Throwable th2) {
            try {
                f.o1(th2);
                l.b(th2);
                throw new OnCompletedFailedException(th2.getMessage(), th2);
            } catch (Throwable th3) {
                try {
                    unsubscribe();
                    throw th3;
                } catch (Throwable th4) {
                    l.b(th4);
                    throw new UnsubscribeFailedException(th4.getMessage(), th4);
                }
            }
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        f.o1(th);
        if (this.k) {
            return;
        }
        this.k = true;
        Objects.requireNonNull(o.a.b());
        try {
            this.j.onError(th);
            try {
                unsubscribe();
            } catch (Throwable th2) {
                l.b(th2);
                throw new OnErrorFailedException(th2);
            }
        } catch (OnErrorNotImplementedException e) {
            try {
                unsubscribe();
                throw e;
            } catch (Throwable th3) {
                l.b(th3);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            l.b(th4);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                l.b(th5);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th5)));
            }
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        try {
            if (this.k) {
                return;
            }
            this.j.onNext(t);
        } catch (Throwable th) {
            f.o1(th);
            onError(th);
        }
    }
}
