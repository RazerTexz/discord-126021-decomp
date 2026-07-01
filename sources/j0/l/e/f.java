package j0.l.e;

import rx.Subscriber;

/* JADX INFO: compiled from: ObserverSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f<T> extends Subscriber<T> {
    public final j0.g<? super T> j;

    public f(j0.g<? super T> gVar) {
        this.j = gVar;
    }

    @Override // j0.g
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.j.onNext(t);
    }
}
