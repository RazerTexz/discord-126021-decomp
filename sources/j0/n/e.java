package j0.n;

import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Subscribers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e<T> extends Subscriber<T> {
    public final /* synthetic */ Subscriber j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.j = subscriber2;
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
