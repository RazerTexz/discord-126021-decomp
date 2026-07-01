package j0.l.a;

import j0.k.Func1;
import j0.l.b.ProducerArbiter;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.f1, reason: use source file name */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorOnErrorResumeNextViaFunction4<T> implements Observable.b<T, T> {
    public final Func1<? super Throwable, ? extends Observable<? extends T>> j;

    public OperatorOnErrorResumeNextViaFunction4(Func1<? super Throwable, ? extends Observable<? extends T>> func1) {
        this.j = func1;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        ProducerArbiter producerArbiter = new ProducerArbiter();
        SerialSubscription serialSubscription = new SerialSubscription();
        OperatorOnErrorResumeNextViaFunction3 operatorOnErrorResumeNextViaFunction3 = new OperatorOnErrorResumeNextViaFunction3(this, subscriber, producerArbiter, serialSubscription);
        serialSubscription.a(operatorOnErrorResumeNextViaFunction3);
        subscriber.add(serialSubscription);
        subscriber.setProducer(producerArbiter);
        return operatorOnErrorResumeNextViaFunction3;
    }
}
