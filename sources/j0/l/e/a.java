package j0.l.e;

import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: ActionObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements j0.g<T> {
    public final Action1<? super T> j;
    public final Action1<? super Throwable> k;
    public final Action0 l;

    public a(Action1<? super T> action1, Action1<? super Throwable> action2, Action0 action0) {
        this.j = action1;
        this.k = action2;
        this.l = action0;
    }

    @Override // j0.g
    public void onCompleted() {
        this.l.call();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.k.call(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.j.call(t);
    }
}
