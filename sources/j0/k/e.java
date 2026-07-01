package j0.k;

import rx.functions.Func3;
import rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e<R> implements FuncN<R> {
    public final /* synthetic */ Func3 a;

    public e(Func3 func3) {
        this.a = func3;
    }

    @Override // rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 3) {
            return (R) this.a.call(objArr[0], objArr[1], objArr[2]);
        }
        throw new IllegalArgumentException("Func3 expecting 3 arguments.");
    }
}
