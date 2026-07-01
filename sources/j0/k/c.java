package j0.k;

import rx.functions.Func9;
import rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c<R> implements FuncN<R> {
    public final /* synthetic */ Func9 a;

    public c(Func9 func9) {
        this.a = func9;
    }

    @Override // rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 9) {
            return (R) this.a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
        }
        throw new IllegalArgumentException("Func9 expecting 9 arguments.");
    }
}
