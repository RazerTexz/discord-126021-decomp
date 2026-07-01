package rx.observers;

import j0.g;
import j0.n.c;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
public class SerializedSubscriber<T> extends Subscriber<T> {
    public final g<T> j;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber, true);
        this.j = new c(subscriber);
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

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z2) {
        super(subscriber, z2);
        this.j = new c(subscriber);
    }
}
