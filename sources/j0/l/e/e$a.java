package j0.l.e;

import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

/* JADX INFO: compiled from: InternalObservableUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a implements Action1<Throwable> {
    @Override // rx.functions.Action1
    public void call(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }
}
