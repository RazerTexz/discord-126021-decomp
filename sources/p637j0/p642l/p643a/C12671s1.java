package p637j0.p642l.p643a;

import p658rx.Producer;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.s1 */
/* JADX INFO: compiled from: OperatorSkip.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12671s1<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public int f27039j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Subscriber f27040k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C12674t1 f27041l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12671s1(C12674t1 c12674t1, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f27041l = c12674t1;
        this.f27040k = subscriber2;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27040k.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27040k.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        int i = this.f27039j;
        if (i >= this.f27041l.f27054j) {
            this.f27040k.onNext(t);
        } else {
            this.f27039j = i + 1;
        }
    }

    @Override // p658rx.Subscriber
    public void setProducer(Producer producer) {
        this.f27040k.setProducer(producer);
        producer.mo10704j(this.f27041l.f27054j);
    }
}
