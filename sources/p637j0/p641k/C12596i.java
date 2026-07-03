package p637j0.p641k;

import p658rx.functions.Func7;
import p658rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j0.k.i */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12596i<R> implements FuncN<R> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Func7 f26717a;

    public C12596i(Func7 func7) {
        this.f26717a = func7;
    }

    @Override // p658rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 7) {
            return (R) this.f26717a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
        }
        throw new IllegalArgumentException("Func7 expecting 7 arguments.");
    }
}
