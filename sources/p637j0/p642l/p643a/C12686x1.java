package p637j0.p642l.p643a;

import p658rx.Observable;
import p658rx.Producer;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.x1 */
/* JADX INFO: compiled from: OperatorSubscribeOn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12686x1<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Scheduler f27108j;

    /* JADX INFO: renamed from: k */
    public final Observable<T> f27109k;

    /* JADX INFO: renamed from: l */
    public final boolean f27110l;

    /* JADX INFO: renamed from: j0.l.a.x1$a */
    /* JADX INFO: compiled from: OperatorSubscribeOn.java */
    public static final class a<T> extends Subscriber<T> implements Action0 {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super T> f27111j;

        /* JADX INFO: renamed from: k */
        public final boolean f27112k;

        /* JADX INFO: renamed from: l */
        public final Scheduler.Worker f27113l;

        /* JADX INFO: renamed from: m */
        public Observable<T> f27114m;

        /* JADX INFO: renamed from: n */
        public Thread f27115n;

        /* JADX INFO: renamed from: j0.l.a.x1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OperatorSubscribeOn.java */
        public class C13349a implements Producer {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ Producer f27116j;

            /* JADX INFO: renamed from: j0.l.a.x1$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: OperatorSubscribeOn.java */
            public class C13350a implements Action0 {

                /* JADX INFO: renamed from: j */
                public final /* synthetic */ long f27118j;

                public C13350a(long j) {
                    this.f27118j = j;
                }

                @Override // p658rx.functions.Action0
                public void call() {
                    C13349a.this.f27116j.mo10704j(this.f27118j);
                }
            }

            public C13349a(Producer producer) {
                this.f27116j = producer;
            }

            @Override // p658rx.Producer
            /* JADX INFO: renamed from: j */
            public void mo10704j(long j) {
                if (a.this.f27115n != Thread.currentThread()) {
                    a aVar = a.this;
                    if (aVar.f27112k) {
                        aVar.f27113l.mo10740a(new C13350a(j));
                        return;
                    }
                }
                this.f27116j.mo10704j(j);
            }
        }

        public a(Subscriber<? super T> subscriber, boolean z2, Scheduler.Worker worker, Observable<T> observable) {
            this.f27111j = subscriber;
            this.f27112k = z2;
            this.f27113l = worker;
            this.f27114m = observable;
        }

        @Override // p658rx.functions.Action0
        public void call() {
            Observable<T> observable = this.f27114m;
            this.f27114m = null;
            this.f27115n = Thread.currentThread();
            observable.m11107i0(this);
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            try {
                this.f27111j.onCompleted();
            } finally {
                this.f27113l.unsubscribe();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            try {
                this.f27111j.onError(th);
            } finally {
                this.f27113l.unsubscribe();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            this.f27111j.onNext(t);
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            this.f27111j.setProducer(new C13349a(producer));
        }
    }

    public C12686x1(Observable<T> observable, Scheduler scheduler, boolean z2) {
        this.f27108j = scheduler;
        this.f27109k = observable;
        this.f27110l = z2;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerMo10739a = this.f27108j.mo10739a();
        a aVar = new a(subscriber, this.f27110l, workerMo10739a, this.f27109k);
        subscriber.add(aVar);
        subscriber.add(workerMo10739a);
        workerMo10739a.mo10740a(aVar);
    }
}
