package j0.l.a;

import rx.Observable$a;
import rx.Observable$b;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeLift.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r<T, R> implements Observable$a<R> {
    public final Observable$a<T> j;
    public final Observable$b<? extends R, ? super T> k;

    public r(Observable$a<T> observable$a, Observable$b<? extends R, ? super T> observable$b) {
        this.j = observable$a;
        this.k = observable$b;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            Observable$b observable$bCall = this.k;
            j0.k.b<Observable$b, Observable$b> bVar = j0.o.l.i;
            if (bVar != null) {
                observable$bCall = bVar.call(observable$bCall);
            }
            Subscriber subscriber2 = (Subscriber) observable$bCall.call(subscriber);
            try {
                subscriber2.onStart();
                this.j.call(subscriber2);
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                subscriber2.onError(th);
            }
        } catch (Throwable th2) {
            b.i.a.f.e.o.f.o1(th2);
            subscriber.onError(th2);
        }
    }
}
