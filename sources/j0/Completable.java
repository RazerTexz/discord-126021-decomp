package j0;

import rx.Subscriber;

/* JADX INFO: renamed from: j0.b, reason: use source file name */
/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes3.dex */
public class Completable extends Subscriber<Object> {
    public final /* synthetic */ CompletableSubscriber j;

    public Completable(Completable2 completable2, CompletableSubscriber completableSubscriber) {
        this.j = completableSubscriber;
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
    public void onNext(Object obj) {
    }
}
