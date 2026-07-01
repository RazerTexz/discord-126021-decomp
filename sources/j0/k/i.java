package j0.k;

import rx.functions.Func7;
import rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i<R> implements FuncN<R> {
    public final /* synthetic */ Func7 a;

    public i(Func7 func7) {
        this.a = func7;
    }

    @Override // rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 7) {
            return (R) this.a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
        }
        throw new IllegalArgumentException("Func7 expecting 7 arguments.");
    }
}
