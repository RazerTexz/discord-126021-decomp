package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.exceptions.OnErrorThrowable;

/* JADX INFO: renamed from: j0.l.a.l */
/* JADX INFO: compiled from: OnSubscribeFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12642l<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Observable<T> f26894j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC12589b<? super T, Boolean> f26895k;

    /* JADX INFO: renamed from: j0.l.a.l$a */
    /* JADX INFO: compiled from: OnSubscribeFilter.java */
    public static final class a<T> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super T> f26896j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC12589b<? super T, Boolean> f26897k;

        /* JADX INFO: renamed from: l */
        public boolean f26898l;

        public a(Subscriber<? super T> subscriber, InterfaceC12589b<? super T, Boolean> interfaceC12589b) {
            this.f26896j = subscriber;
            this.f26897k = interfaceC12589b;
            request(0L);
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (this.f26898l) {
                return;
            }
            this.f26896j.onCompleted();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (this.f26898l) {
                C12774l.m10863b(th);
            } else {
                this.f26898l = true;
                this.f26896j.onError(th);
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            try {
                if (this.f26897k.call(t).booleanValue()) {
                    this.f26896j.onNext(t);
                } else {
                    request(1L);
                }
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                unsubscribe();
                onError(OnErrorThrowable.m11126a(th, t));
            }
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.f26896j.setProducer(producer);
        }
    }

    public C12642l(Observable<T> observable, InterfaceC12589b<? super T, Boolean> interfaceC12589b) {
        this.f26894j = observable;
        this.f26895k = interfaceC12589b;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.f26895k);
        subscriber.add(aVar);
        this.f26894j.m11107i0(aVar);
    }
}
