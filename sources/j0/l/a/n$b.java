package j0.l.a;

import java.util.Iterator;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n$b<T, R> implements Observable$a<R> {
    public final T j;
    public final j0.k.b<? super T, ? extends Iterable<? extends R>> k;

    public n$b(T t, j0.k.b<? super T, ? extends Iterable<? extends R>> bVar) {
        this.j = t;
        this.k = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            Iterator<? extends R> it = this.k.call(this.j).iterator();
            if (it.hasNext()) {
                subscriber.setProducer(new q$a(subscriber, it));
            } else {
                subscriber.onCompleted();
            }
        } catch (Throwable th) {
            b.i.a.f.e.o.f.p1(th, subscriber, this.j);
        }
    }
}
