package p637j0.p642l.p643a;

import p637j0.C12580f;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.v */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12678v implements Observable.InterfaceC13006b<C12580f<?>, C12580f<?>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12687y f27064j;

    public C12678v(C12687y c12687y) {
        this.f27064j = c12687y;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new C12675u(this, subscriber, subscriber);
    }
}
