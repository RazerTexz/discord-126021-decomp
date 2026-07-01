package j0.l.a;

import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.x1, reason: use source file name */
/* JADX INFO: compiled from: OperatorSubscribeOn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorSubscribeOn<T> implements Observable.a<T> {
    public final Scheduler j;
    public final Observable<T> k;
    public final boolean l;

    /* JADX INFO: renamed from: j0.l.a.x1$a */
    /* JADX INFO: compiled from: OperatorSubscribeOn.java */
    public static final class a<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super T> j;
        public final boolean k;
        public final Scheduler.Worker l;
        public Observable<T> m;
        public Thread n;

        /* JADX INFO: renamed from: j0.l.a.x1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OperatorSubscribeOn.java */
        public class C0427a implements Producer {
            public final /* synthetic */ Producer j;

            /* JADX INFO: renamed from: j0.l.a.x1$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: OperatorSubscribeOn.java */
            public class C0428a implements Action0 {
                public final /* synthetic */ long j;

                public C0428a(long j) {
                    this.j = j;
                }

                @Override // rx.functions.Action0
                public void call() {
                    C0427a.this.j.j(this.j);
                }
            }

            public C0427a(Producer producer) {
                this.j = producer;
            }

            @Override // rx.Producer
            public void j(long j) {
                if (a.this.n != Thread.currentThread()) {
                    a aVar = a.this;
                    if (aVar.k) {
                        aVar.l.a(new C0428a(j));
                        return;
                    }
                }
                this.j.j(j);
            }
        }

        public a(Subscriber<? super T> subscriber, boolean z2, Scheduler.Worker worker, Observable<T> observable) {
            this.j = subscriber;
            this.k = z2;
            this.l = worker;
            this.m = observable;
        }

        @Override // rx.functions.Action0
        public void call() {
            Observable<T> observable = this.m;
            this.m = null;
            this.n = Thread.currentThread();
            observable.i0(this);
        }

        @Override // j0.Observer2
        public void onCompleted() {
            try {
                this.j.onCompleted();
            } finally {
                this.l.unsubscribe();
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            try {
                this.j.onError(th);
            } finally {
                this.l.unsubscribe();
            }
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            this.j.onNext(t);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.j.setProducer(new C0427a(producer));
        }
    }

    public OperatorSubscribeOn(Observable<T> observable, Scheduler scheduler, boolean z2) {
        this.j = scheduler;
        this.k = observable;
        this.l = z2;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerA = this.j.a();
        a aVar = new a(subscriber, this.l, workerA, this.k);
        subscriber.add(aVar);
        subscriber.add(workerA);
        workerA.a(aVar);
    }
}
