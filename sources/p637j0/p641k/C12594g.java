package p637j0.p641k;

import p658rx.functions.Func5;
import p658rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j0.k.g */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12594g<R> implements FuncN<R> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Func5 f26715a;

    public C12594g(Func5 func5) {
        this.f26715a = func5;
    }

    @Override // p658rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 5) {
            return (R) this.f26715a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
        }
        throw new IllegalArgumentException("Func5 expecting 5 arguments.");
    }
}
