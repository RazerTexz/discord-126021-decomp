package j0.n;

import j0.g;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: compiled from: Observers.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a implements g<Object> {
    @Override // j0.g
    public final void onCompleted() {
    }

    @Override // j0.g
    public final void onError(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    @Override // j0.g
    public final void onNext(Object obj) {
    }
}
