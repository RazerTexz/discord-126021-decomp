package p637j0.p642l.p643a;

import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.i2 */
/* JADX INFO: compiled from: OperatorTakeWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12633i2<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final Func2<? super T, ? super Integer, Boolean> f26851j;

    /* JADX INFO: renamed from: j0.l.a.i2$a */
    /* JADX INFO: compiled from: OperatorTakeWhile.java */
    public class a implements Func2<T, Integer, Boolean> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ InterfaceC12589b f26852j;

        public a(InterfaceC12589b interfaceC12589b) {
            this.f26852j = interfaceC12589b;
        }

        @Override // p658rx.functions.Func2
        public Boolean call(Object obj, Integer num) {
            return (Boolean) this.f26852j.call(obj);
        }
    }

    public C12633i2(InterfaceC12589b<? super T, Boolean> interfaceC12589b) {
        this.f26851j = new a(interfaceC12589b);
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        C12637j2 c12637j2 = new C12637j2(this, subscriber, false, subscriber);
        subscriber.add(c12637j2);
        return c12637j2;
    }
}
