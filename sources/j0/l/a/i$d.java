package j0.l.a;

import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: OnSubscribeCreate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i$d<T> extends i$f<T> {
    private static final long serialVersionUID = 338953216916120960L;
    private boolean done;

    public i$d(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    @Override // j0.l.a.i$f
    public void c() {
        onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }

    @Override // j0.l.a.i$a, j0.g
    public void onCompleted() {
        if (this.done) {
            return;
        }
        this.done = true;
        super.onCompleted();
    }

    @Override // j0.l.a.i$a, j0.g
    public void onError(Throwable th) {
        if (this.done) {
            j0.o.l.b(th);
        } else {
            this.done = true;
            super.onError(th);
        }
    }

    @Override // j0.l.a.i$f, j0.g
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        super.onNext(t);
    }
}
