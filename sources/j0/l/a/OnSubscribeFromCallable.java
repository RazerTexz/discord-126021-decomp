package j0.l.a;

import j0.l.b.SingleDelayedProducer;
import java.util.concurrent.Callable;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.p, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeFromCallable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeFromCallable<T> implements Observable.a<T> {
    public final Callable<? extends T> j;

    public OnSubscribeFromCallable(Callable<? extends T> callable) {
        this.j = callable;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        subscriber.setProducer(singleDelayedProducer);
        try {
            singleDelayedProducer.b(this.j.call());
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            subscriber.onError(th);
        }
    }
}
