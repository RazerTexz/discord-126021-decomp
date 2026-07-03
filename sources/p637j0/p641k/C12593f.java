package p637j0.p641k;

import p658rx.functions.Func4;
import p658rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j0.k.f */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12593f<R> implements FuncN<R> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Func4 f26714a;

    public C12593f(Func4 func4) {
        this.f26714a = func4;
    }

    @Override // p658rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 4) {
            return (R) this.f26714a.call(objArr[0], objArr[1], objArr[2], objArr[3]);
        }
        throw new IllegalArgumentException("Func4 expecting 4 arguments.");
    }
}
