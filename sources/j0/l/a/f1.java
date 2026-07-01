package j0.l.a;

import rx.Observable;
import rx.Observable$b;
import rx.Subscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f1<T> implements Observable$b<T, T> {
    public final j0.k.b<? super Throwable, ? extends Observable<? extends T>> j;

    public f1(j0.k.b<? super Throwable, ? extends Observable<? extends T>> bVar) {
        this.j = bVar;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        j0.l.b.a aVar = new j0.l.b.a();
        SerialSubscription serialSubscription = new SerialSubscription();
        e1 e1Var = new e1(this, subscriber, aVar, serialSubscription);
        serialSubscription.a(e1Var);
        subscriber.add(serialSubscription);
        subscriber.setProducer(aVar);
        return e1Var;
    }
}
