package j0.n;

import j0.Observer2;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.n.d, reason: use source file name */
/* JADX INFO: compiled from: Subscribers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Subscribers<T> extends Subscriber<T> {
    public final /* synthetic */ Observer2 j;

    public Subscribers(Observer2 observer2) {
        this.j = observer2;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        this.j.onNext(t);
    }
}
