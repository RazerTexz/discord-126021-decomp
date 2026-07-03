package p630i0.p631d0.p632a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p630i0.InterfaceC12504d;
import p658rx.Observable;
import p658rx.Subscriber;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.d0.a.c */
/* JADX INFO: compiled from: CallExecuteOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12507c<T> implements Observable.InterfaceC13005a<Response<T>> {

    /* JADX INFO: renamed from: j */
    public final InterfaceC12504d<T> f26500j;

    public C12507c(InterfaceC12504d<T> interfaceC12504d) {
        this.f26500j = interfaceC12504d;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        InterfaceC12504d<T> interfaceC12504dClone = this.f26500j.clone();
        C12506b c12506b = new C12506b(interfaceC12504dClone, subscriber);
        subscriber.add(c12506b);
        subscriber.setProducer(c12506b);
        try {
            c12506b.m10703c(interfaceC12504dClone.execute());
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            c12506b.m10702b(th);
        }
    }
}
