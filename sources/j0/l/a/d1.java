package j0.l.a;

import rx.Observable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d1<T> implements j0.k.b<Throwable, Observable<? extends T>> {
    public final /* synthetic */ Observable j;

    public d1(Observable observable) {
        this.j = observable;
    }

    @Override // j0.k.b
    public Object call(Throwable th) {
        return this.j;
    }
}
