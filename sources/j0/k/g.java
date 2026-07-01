package j0.k;

import rx.functions.Func5;
import rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g<R> implements FuncN<R> {
    public final /* synthetic */ Func5 a;

    public g(Func5 func5) {
        this.a = func5;
    }

    @Override // rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 5) {
            return (R) this.a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
        }
        throw new IllegalArgumentException("Func5 expecting 5 arguments.");
    }
}
