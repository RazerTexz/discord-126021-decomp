package j0.l.e;

import rx.Observable;

/* JADX INFO: compiled from: InternalObservableUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$c implements j0.k.b<Observable<? extends j0.f<?>>, Observable<?>> {
    public final j0.k.b<? super Observable<? extends Void>, ? extends Observable<?>> j;

    public e$c(j0.k.b<? super Observable<? extends Void>, ? extends Observable<?>> bVar) {
        this.j = bVar;
    }

    @Override // j0.k.b
    public Observable<?> call(Observable<? extends j0.f<?>> observable) {
        return this.j.call(observable.G(e.j));
    }
}
