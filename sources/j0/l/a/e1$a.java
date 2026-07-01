package j0.l.a;

import rx.Producer;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public class e1$a<T> extends Subscriber<T> {
    public final /* synthetic */ e1 j;

    public e1$a(e1 e1Var) {
        this.j = e1Var;
    }

    @Override // j0.g
    public void onCompleted() {
        this.j.l.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.j.l.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.j.l.onNext(t);
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.j.m.c(producer);
    }
}
