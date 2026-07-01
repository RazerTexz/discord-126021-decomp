package j0.l.e;

import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: ActionSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> extends Subscriber<T> {
    public final Action1<? super T> j;
    public final Action1<Throwable> k;
    public final Action0 l;

    public b(Action1<? super T> action1, Action1<Throwable> action2, Action0 action0) {
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
