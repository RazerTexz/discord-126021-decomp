package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.r */
/* JADX INFO: compiled from: OnSubscribeLift.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12666r<T, R> implements Observable.InterfaceC13005a<R> {

    /* JADX INFO: renamed from: j */
    public final Observable.InterfaceC13005a<T> f27013j;

    /* JADX INFO: renamed from: k */
    public final Observable.InterfaceC13006b<? extends R, ? super T> f27014k;

    public C12666r(Observable.InterfaceC13005a<T> interfaceC13005a, Observable.InterfaceC13006b<? extends R, ? super T> interfaceC13006b) {
        this.f27013j = interfaceC13005a;
        this.f27014k = interfaceC13006b;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            Observable.InterfaceC13006b interfaceC13006bCall = this.f27014k;
            InterfaceC12589b<Observable.InterfaceC13006b, Observable.InterfaceC13006b> interfaceC12589b = C12774l.f27382i;
            if (interfaceC12589b != null) {
                interfaceC13006bCall = interfaceC12589b.call(interfaceC13006bCall);
            }
            Subscriber subscriber2 = (Subscriber) interfaceC13006bCall.call(subscriber);
            try {
                subscriber2.onStart();
                this.f27013j.call(subscriber2);
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                subscriber2.onError(th);
            }
        } catch (Throwable th2) {
            C3404f.m4325o1(th2);
            subscriber.onError(th2);
        }
    }
}
