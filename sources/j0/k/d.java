package j0.k;

import rx.functions.Func2;
import rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d<R> implements FuncN<R> {
    public final /* synthetic */ Func2 a;

    public d(Func2 func2) {
        this.a = func2;
    }

    @Override // rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 2) {
            return (R) this.a.call(objArr[0], objArr[1]);
        }
        throw new IllegalArgumentException("Func2 expecting 2 arguments.");
    }
}
