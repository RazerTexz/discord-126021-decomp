package p658rx.observers;

import p637j0.InterfaceC12581g;
import p637j0.p651n.C12760c;
import p658rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
public class SerializedSubscriber<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final InterfaceC12581g<T> f27646j;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber, true);
        this.f27646j = new C12760c(subscriber);
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27646j.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27646j.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f27646j.onNext(t);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z2) {
        super(subscriber, z2);
        this.f27646j = new C12760c(subscriber);
    }
}
