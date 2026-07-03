package p637j0.p641k;

import p658rx.functions.Func2;
import p658rx.functions.FuncN;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: renamed from: j0.k.d */
/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12591d<R> implements FuncN<R> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Func2 f26712a;

    public C12591d(Func2 func2) {
        this.f26712a = func2;
    }

    @Override // p658rx.functions.FuncN
    public R call(Object... objArr) {
        if (objArr.length == 2) {
            return (R) this.f26712a.call(objArr[0], objArr[1]);
        }
        throw new IllegalArgumentException("Func2 expecting 2 arguments.");
    }
}
