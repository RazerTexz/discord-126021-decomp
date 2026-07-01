package j0.l.a;

import rx.Observable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c1<T> implements j0.k.b<Throwable, Observable<? extends T>> {
    public final /* synthetic */ j0.k.b j;

    public c1(j0.k.b bVar) {
        this.j = bVar;
    }

    @Override // j0.k.b
    public Object call(Throwable th) {
        return new j0.l.e.k(this.j.call(th));
    }
}
