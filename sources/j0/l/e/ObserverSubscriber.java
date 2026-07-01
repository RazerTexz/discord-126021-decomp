package j0.l.e;

import j0.Observer2;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.e.f, reason: use source file name */
/* JADX INFO: compiled from: ObserverSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ObserverSubscriber<T> extends Subscriber<T> {
    public final Observer2<? super T> j;

    public ObserverSubscriber(Observer2<? super T> observer2) {
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
