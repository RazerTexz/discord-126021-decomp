package p637j0.p641k;

import p658rx.functions.Func9;
import p658rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j0.k.c */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12590c<R> implements FuncN<R> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Func9 f26711a;

    public C12590c(Func9 func9) {
        this.f26711a = func9;
    }

    @Override // p658rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 9) {
            return (R) this.f26711a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
        }
        throw new IllegalArgumentException("Func9 expecting 9 arguments.");
    }
}
