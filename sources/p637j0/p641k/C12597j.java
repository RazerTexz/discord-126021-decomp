package p637j0.p641k;

import p658rx.functions.Func8;
import p658rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j0.k.j */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12597j<R> implements FuncN<R> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Func8 f26718a;

    public C12597j(Func8 func8) {
        this.f26718a = func8;
    }

    @Override // p658rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 8) {
            return (R) this.f26718a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
        }
        throw new IllegalArgumentException("Func8 expecting 8 arguments.");
    }
}
