package p637j0.p641k;

import p658rx.functions.Func6;
import p658rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j0.k.h */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12595h<R> implements FuncN<R> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Func6 f26716a;

    public C12595h(Func6 func6) {
        this.f26716a = func6;
    }

    @Override // p658rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 6) {
            return (R) this.f26716a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
        }
        throw new IllegalArgumentException("Func6 expecting 6 arguments.");
    }
}
