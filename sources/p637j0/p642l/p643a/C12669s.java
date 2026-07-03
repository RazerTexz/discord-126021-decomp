package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.exceptions.OnErrorThrowable;

/* JADX INFO: renamed from: j0.l.a.s */
/* JADX INFO: compiled from: OnSubscribeMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12669s<T, R> implements Observable.InterfaceC13005a<R> {

    /* JADX INFO: renamed from: j */
    public final Observable<T> f27031j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC12589b<? super T, ? extends R> f27032k;

    /* JADX INFO: renamed from: j0.l.a.s$a */
    /* JADX INFO: compiled from: OnSubscribeMap.java */
    public static final class a<T, R> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super R> f27033j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC12589b<? super T, ? extends R> f27034k;

        /* JADX INFO: renamed from: l */
        public boolean f27035l;

        public a(Subscriber<? super R> subscriber, InterfaceC12589b<? super T, ? extends R> interfaceC12589b) {
            this.f27033j = subscriber;
            this.f27034k = interfaceC12589b;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (this.f27035l) {
                return;
            }
            this.f27033j.onCompleted();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (this.f27035l) {
                C12774l.m10863b(th);
            } else {
                this.f27035l = true;
                this.f27033j.onError(th);
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            try {
                this.f27033j.onNext(this.f27034k.call(t));
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                unsubscribe();
                onError(OnErrorThrowable.m11126a(th, t));
            }
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            this.f27033j.setProducer(producer);
        }
    }

    public C12669s(Observable<T> observable, InterfaceC12589b<? super T, ? extends R> interfaceC12589b) {
        this.f27031j = observable;
        this.f27032k = interfaceC12589b;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.f27032k);
        subscriber.add(aVar);
        this.f27031j.m11107i0(aVar);
    }
}
