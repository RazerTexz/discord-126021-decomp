package j0.k;

import rx.functions.Func6;
import rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h<R> implements FuncN<R> {
    public final /* synthetic */ Func6 a;

    public h(Func6 func6) {
        this.a = func6;
    }

    @Override // rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 6) {
            return (R) this.a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
        }
        throw new IllegalArgumentException("Func6 expecting 6 arguments.");
    }
}
