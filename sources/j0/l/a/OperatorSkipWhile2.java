package j0.l.a;

import j0.k.Func1;
import rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.v1, reason: use source file name */
/* JADX INFO: compiled from: OperatorSkipWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorSkipWhile2<T> implements Func2<T, Integer, Boolean> {
    public final /* synthetic */ Func1 j;

    public OperatorSkipWhile2(Func1 func1) {
        this.j = func1;
    }

    @Override // rx.functions.Func2
    public Boolean call(Object obj, Integer num) {
        return (Boolean) this.j.call(obj);
    }
}
