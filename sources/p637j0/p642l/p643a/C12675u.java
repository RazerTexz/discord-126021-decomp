package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import p637j0.C12580f;
import p658rx.Producer;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.u */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12675u extends Subscriber<C12580f<?>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Subscriber f27055j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C12678v f27056k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12675u(C12678v c12678v, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f27056k = c12678v;
        this.f27055j = subscriber2;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27055j.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27055j.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(Object obj) {
        C12580f c12580f = (C12580f) obj;
        C12580f.a aVar = c12580f.f26689b;
        if ((aVar == C12580f.a.OnCompleted) && this.f27056k.f27064j.f27122l) {
            this.f27055j.onCompleted();
            return;
        }
        if ((aVar == C12580f.a.OnError) && this.f27056k.f27064j.f27123m) {
            this.f27055j.onError(c12580f.f26690c);
        } else {
            this.f27055j.onNext(c12580f);
        }
    }

    @Override // p658rx.Subscriber
    public void setProducer(Producer producer) {
        producer.mo10704j(RecyclerView.FOREVER_NS);
    }
}
