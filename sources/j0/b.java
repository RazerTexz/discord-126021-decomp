package j0;

import rx.Subscriber;

/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends Subscriber<Object> {
    public final /* synthetic */ e j;

    public b(c cVar, e eVar) {
        this.j = eVar;
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
    public void onNext(Object obj) {
    }
}
