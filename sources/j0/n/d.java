package j0.n;

import j0.g;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Subscribers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d<T> extends Subscriber<T> {
    public final /* synthetic */ g j;

    public d(g gVar) {
        this.j = gVar;
    }

    @Override // j0.g
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.j.onNext(t);
    }
}
