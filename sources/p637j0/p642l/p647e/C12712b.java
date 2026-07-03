package p637j0.p642l.p647e;

import p658rx.Subscriber;
import p658rx.functions.Action0;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: j0.l.e.b */
/* JADX INFO: compiled from: ActionSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12712b<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final Action1<? super T> f27265j;

    /* JADX INFO: renamed from: k */
    public final Action1<Throwable> f27266k;

    /* JADX INFO: renamed from: l */
    public final Action0 f27267l;

    public C12712b(Action1<? super T> action1, Action1<Throwable> action2, Action0 action0) {
        this.f27265j = action1;
        this.f27266k = action2;
        this.f27267l = action0;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27267l.call();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27266k.call(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f27265j.call(t);
    }
}
