package j0.k;

import rx.functions.Func8;
import rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j<R> implements FuncN<R> {
    public final /* synthetic */ Func8 a;

    public j(Func8 func8) {
        this.a = func8;
    }

    @Override // rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 8) {
            return (R) this.a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
        }
        throw new IllegalArgumentException("Func8 expecting 8 arguments.");
    }
}
