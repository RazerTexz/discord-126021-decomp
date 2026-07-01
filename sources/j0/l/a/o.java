package j0.l.a;

import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeFromArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o<T> implements Observable$a<T> {
    public final T[] j;

    public o(T[] tArr) {
        this.j = tArr;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.setProducer(new o$a(subscriber, this.j));
    }
}
