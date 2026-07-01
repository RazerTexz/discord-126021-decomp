package j0.l.a;

import rx.Producer;
import rx.Subscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public class e1<T> extends Subscriber<T> {
    public boolean j;
    public long k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ j0.l.b.a m;
    public final /* synthetic */ SerialSubscription n;
    public final /* synthetic */ f1 o;

    public e1(f1 f1Var, Subscriber subscriber, j0.l.b.a aVar, SerialSubscription serialSubscription) {
        this.o = f1Var;
        this.l = subscriber;
        this.m = aVar;
        this.n = serialSubscription;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.j) {
            return;
        }
        this.j = true;
        this.l.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.j) {
            b.i.a.f.e.o.f.o1(th);
            j0.o.l.b(th);
            return;
        }
        this.j = true;
        try {
            unsubscribe();
            e1$a e1_a = new e1$a(this);
            this.n.a(e1_a);
            long j = this.k;
            if (j != 0) {
                this.m.b(j);
            }
            this.o.j.call(th).i0(e1_a);
        } catch (Throwable th2) {
            Subscriber subscriber = this.l;
            b.i.a.f.e.o.f.o1(th2);
            subscriber.onError(th2);
        }
    }

    @Override // j0.g
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
