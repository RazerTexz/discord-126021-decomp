package p637j0.p642l.p647e;

import p637j0.InterfaceC12581g;
import p658rx.functions.Action0;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: j0.l.e.a */
/* JADX INFO: compiled from: ActionObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12711a<T> implements InterfaceC12581g<T> {

    /* JADX INFO: renamed from: j */
    public final Action1<? super T> f27262j;

    /* JADX INFO: renamed from: k */
    public final Action1<? super Throwable> f27263k;

    /* JADX INFO: renamed from: l */
    public final Action0 f27264l;

    public C12711a(Action1<? super T> action1, Action1<? super Throwable> action2, Action0 action0) {
        this.f27262j = action1;
        this.f27263k = action2;
        this.f27264l = action0;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27264l.call();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27263k.call(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f27262j.call(t);
    }
}
