package j0.l.a;

import rx.functions.Func0;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: OperatorScan.java */
/* JADX INFO: loaded from: classes3.dex */
public class o1$a<R> implements Func0<R> {
    public final /* synthetic */ Object j;

    public o1$a(Object obj) {
        this.j = obj;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public R call() {
        return (R) this.j;
    }
}
