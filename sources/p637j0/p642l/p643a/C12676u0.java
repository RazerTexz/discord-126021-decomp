package p637j0.p642l.p643a;

import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12723m;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: j0.l.a.u0 */
/* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12676u0<T, U> implements Observable.InterfaceC13006b<T, T>, Func2<U, U, Boolean> {

    /* JADX INFO: renamed from: j */
    public final InterfaceC12589b<? super T, ? extends U> f27057j;

    /* JADX INFO: renamed from: k */
    public final Func2<? super U, ? super U, Boolean> f27058k;

    /* JADX INFO: renamed from: j0.l.a.u0$a */
    /* JADX INFO: compiled from: OperatorDistinctUntilChanged.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final C12676u0<?, ?> f27059a = new C12676u0<>(C12723m.a.INSTANCE);
    }

    public C12676u0(InterfaceC12589b<? super T, ? extends U> interfaceC12589b) {
        this.f27057j = interfaceC12589b;
        this.f27058k = this;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new C12673t0(this, subscriber, subscriber);
    }

    @Override // p658rx.functions.Func2
    public Boolean call(Object obj, Object obj2) {
        return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
    }

    public C12676u0(Func2<? super U, ? super U, Boolean> func2) {
        this.f27057j = C12723m.a.INSTANCE;
        this.f27058k = func2;
    }
}
