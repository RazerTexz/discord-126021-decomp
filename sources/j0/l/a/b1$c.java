package j0.l.a;

import rx.Subscriber;

/* JADX INFO: compiled from: OperatorOnBackpressureLatest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b1$c<T> extends Subscriber<T> {
    public final b1$b<T> j;

    public b1$c(b1$b<T> b1_b) {
        this.j = b1_b;
    }

    @Override // j0.g
    public void onCompleted() throws Throwable {
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) throws Throwable {
        b1$b<T> b1_b = this.j;
        b1_b.terminal = th;
        b1_b.done = true;
        b1_b.a();
    }

    @Override // j0.g
    public void onNext(T t) throws Throwable {
        b1$b<T> b1_b = this.j;
        b1_b.value.lazySet(t);
        b1_b.a();
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(0L);
    }
}
