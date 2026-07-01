package j0.l.a;

import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.c1, reason: use source file name */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorOnErrorResumeNextViaFunction<T> implements Func1<Throwable, Observable<? extends T>> {
    public final /* synthetic */ Func1 j;

    public OperatorOnErrorResumeNextViaFunction(Func1 func1) {
        this.j = func1;
    }

    @Override // j0.k.Func1
    public Object call(Throwable th) {
        return new ScalarSynchronousObservable(this.j.call(th));
    }
}
