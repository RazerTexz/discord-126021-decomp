package j0.l.a;

import rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorSkipWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v1<T> implements Func2<T, Integer, Boolean> {
    public final /* synthetic */ j0.k.b j;

    public v1(j0.k.b bVar) {
        this.j = bVar;
    }

    @Override // rx.functions.Func2
    public Boolean call(Object obj, Integer num) {
        return (Boolean) this.j.call(obj);
    }
}
