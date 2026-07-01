package rx.observers;

import j0.Observer2;
import j0.n.SerializedObserver;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
public class SerializedSubscriber<T> extends Subscriber<T> {
    public final Observer2<T> j;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber, true);
        this.j = new SerializedObserver(subscriber);
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        this.j.onNext(t);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z2) {
        super(subscriber, z2);
        this.j = new SerializedObserver(subscriber);
    }
}
