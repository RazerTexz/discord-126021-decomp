package j0.l.a;

import j0.k.Func1;
import rx.Observable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.d1, reason: use source file name */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorOnErrorResumeNextViaFunction2<T> implements Func1<Throwable, Observable<? extends T>> {
    public final /* synthetic */ Observable j;

    public OperatorOnErrorResumeNextViaFunction2(Observable observable) {
        this.j = observable;
    }

    @Override // j0.k.Func1
    public Object call(Throwable th) {
        return this.j;
    }
}
