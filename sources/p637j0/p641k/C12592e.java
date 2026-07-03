package p637j0.p641k;

import p658rx.functions.Func3;
import p658rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j0.k.e */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12592e<R> implements FuncN<R> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Func3 f26713a;

    public C12592e(Func3 func3) {
        this.f26713a = func3;
    }

    @Override // p658rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 3) {
            return (R) this.f26713a.call(objArr[0], objArr[1], objArr[2]);
        }
        throw new IllegalArgumentException("Func3 expecting 3 arguments.");
    }
}
