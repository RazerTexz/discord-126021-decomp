package j0.l.a;

import rx.Producer;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorSkip.java */
/* JADX INFO: loaded from: classes3.dex */
public class s1<T> extends Subscriber<T> {
    public int j;
    public final /* synthetic */ Subscriber k;
    public final /* synthetic */ t1 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(t1 t1Var, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.l = t1Var;
        this.k = subscriber2;
    }

    @Override // j0.g
    public void onCompleted() {
        this.k.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.k.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        int i = this.j;
        if (i >= this.l.j) {
            this.k.onNext(t);
        } else {
            this.j = i + 1;
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.k.setProducer(producer);
        producer.j(this.l.j);
    }
}
