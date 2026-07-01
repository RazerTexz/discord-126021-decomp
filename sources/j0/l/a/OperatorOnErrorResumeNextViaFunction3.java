package j0.l.a;

import j0.l.b.ProducerArbiter;
import rx.Producer;
import rx.Subscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.e1, reason: use source file name */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorOnErrorResumeNextViaFunction3<T> extends Subscriber<T> {
    public boolean j;
    public long k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ ProducerArbiter m;
    public final /* synthetic */ SerialSubscription n;
    public final /* synthetic */ OperatorOnErrorResumeNextViaFunction4 o;

    /* JADX INFO: renamed from: j0.l.a.e1$a */
    /* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
    public class a extends Subscriber<T> {
        public a() {
        }

        @Override // j0.Observer2
        public void onCompleted() {
            OperatorOnErrorResumeNextViaFunction3.this.l.onCompleted();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            OperatorOnErrorResumeNextViaFunction3.this.l.onError(th);
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            OperatorOnErrorResumeNextViaFunction3.this.l.onNext(t);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            OperatorOnErrorResumeNextViaFunction3.this.m.c(producer);
        }
    }

    public OperatorOnErrorResumeNextViaFunction3(OperatorOnErrorResumeNextViaFunction4 operatorOnErrorResumeNextViaFunction4, Subscriber subscriber, ProducerArbiter producerArbiter, SerialSubscription serialSubscription) {
        this.o = operatorOnErrorResumeNextViaFunction4;
        this.l = subscriber;
        this.m = producerArbiter;
        this.n = serialSubscription;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        if (this.j) {
            return;
        }
        this.j = true;
        this.l.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        if (this.j) {
            b.i.a.f.e.o.f.o1(th);
            j0.o.l.b(th);
            return;
        }
        this.j = true;
        try {
            unsubscribe();
            a aVar = new a();
            this.n.a(aVar);
            long j = this.k;
            if (j != 0) {
                this.m.b(j);
            }
            this.o.j.call(th).i0(aVar);
        } catch (Throwable th2) {
            Subscriber subscriber = this.l;
            b.i.a.f.e.o.f.o1(th2);
            subscriber.onError(th2);
        }
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        if (this.j) {
            return;
        }
        this.k++;
        this.l.onNext(t);
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.m.c(producer);
    }
}
