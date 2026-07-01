package j0.l.a;

import j0.k.Func1;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.r, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeLift.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeLift<T, R> implements Observable.a<R> {
    public final Observable.a<T> j;
    public final Observable.b<? extends R, ? super T> k;

    public OnSubscribeLift(Observable.a<T> aVar, Observable.b<? extends R, ? super T> bVar) {
        this.j = aVar;
        this.k = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            Observable.b bVarCall = this.k;
            Func1<Observable.b, Observable.b> func1 = j0.o.l.i;
            if (func1 != null) {
                bVarCall = func1.call(bVarCall);
            }
            Subscriber subscriber2 = (Subscriber) bVarCall.call(subscriber);
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
