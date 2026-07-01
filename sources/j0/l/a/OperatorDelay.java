package j0.l.a;

import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.r0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDelay.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorDelay<T> extends Subscriber<T> {
    public boolean j;
    public final /* synthetic */ Scheduler.Worker k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ OperatorDelay2 m;

    /* JADX INFO: renamed from: j0.l.a.r0$a */
    /* JADX INFO: compiled from: OperatorDelay.java */
    public class a implements Action0 {
        public a() {
        }

        @Override // rx.functions.Action0
        public void call() {
            OperatorDelay operatorDelay = OperatorDelay.this;
            if (operatorDelay.j) {
                return;
            }
            operatorDelay.j = true;
            operatorDelay.l.onCompleted();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.r0$b */
    /* JADX INFO: compiled from: OperatorDelay.java */
    public class b implements Action0 {
        public final /* synthetic */ Throwable j;

        public b(Throwable th) {
            this.j = th;
        }

        @Override // rx.functions.Action0
        public void call() {
            OperatorDelay operatorDelay = OperatorDelay.this;
            if (operatorDelay.j) {
                return;
            }
            operatorDelay.j = true;
            operatorDelay.l.onError(this.j);
            OperatorDelay.this.k.unsubscribe();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.r0$c */
    /* JADX INFO: compiled from: OperatorDelay.java */
    public class c implements Action0 {
        public final /* synthetic */ Object j;

        public c(Object obj) {
            this.j = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Action0
        public void call() {
            OperatorDelay operatorDelay = OperatorDelay.this;
            if (operatorDelay.j) {
                return;
            }
            operatorDelay.l.onNext(this.j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorDelay(OperatorDelay2 operatorDelay2, Subscriber subscriber, Scheduler.Worker worker, Subscriber subscriber2) {
        super(subscriber);
        this.m = operatorDelay2;
        this.k = worker;
        this.l = subscriber2;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        Scheduler.Worker worker = this.k;
        a aVar = new a();
        OperatorDelay2 operatorDelay2 = this.m;
        worker.b(aVar, operatorDelay2.j, operatorDelay2.k);
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.k.a(new b(th));
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        Scheduler.Worker worker = this.k;
        c cVar = new c(t);
        OperatorDelay2 operatorDelay2 = this.m;
        worker.b(cVar, operatorDelay2.j, operatorDelay2.k);
    }
}
