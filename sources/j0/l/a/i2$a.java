package j0.l.a;

import rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorTakeWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public class i2$a<T> implements Func2<T, Integer, Boolean> {
    public final /* synthetic */ j0.k.b j;

    public i2$a(j0.k.b bVar) {
        this.j = bVar;
    }

    @Override // rx.functions.Func2
    public Boolean call(Object obj, Integer num) {
        return (Boolean) this.j.call(obj);
    }
}
