package p637j0.p642l.p643a;

import java.util.List;
import p637j0.p642l.p644b.C12694b;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.n2 */
/* JADX INFO: compiled from: OperatorToObservableList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12653n2<T> implements Observable.InterfaceC13006b<List<T>, T> {

    /* JADX INFO: renamed from: j0.l.a.n2$a */
    /* JADX INFO: compiled from: OperatorToObservableList.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final C12653n2<Object> f26954a = new C12653n2<>();
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        C12694b c12694b = new C12694b(subscriber);
        C12649m2 c12649m2 = new C12649m2(this, c12694b, subscriber);
        subscriber.add(c12649m2);
        subscriber.setProducer(c12694b);
        return c12649m2;
    }
}
