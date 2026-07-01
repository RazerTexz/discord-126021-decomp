package j0.l.a;

import java.util.concurrent.Callable;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeFromCallable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p<T> implements Observable$a<T> {
    public final Callable<? extends T> j;

    public p(Callable<? extends T> callable) {
        this.j = callable;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        j0.l.b.b bVar = new j0.l.b.b(subscriber);
        subscriber.setProducer(bVar);
        try {
            bVar.b(this.j.call());
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            subscriber.onError(th);
        }
    }
}
