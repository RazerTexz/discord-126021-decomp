package j0.k;

import rx.functions.Func4;
import rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f<R> implements FuncN<R> {
    public final /* synthetic */ Func4 a;

    public f(Func4 func4) {
        this.a = func4;
    }

    @Override // rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 4) {
            return (R) this.a.call(objArr[0], objArr[1], objArr[2], objArr[3]);
        }
        throw new IllegalArgumentException("Func4 expecting 4 arguments.");
    }
}
