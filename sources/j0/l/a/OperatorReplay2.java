package j0.l.a;

import j0.l.a.OperatorReplay;
import rx.functions.Func0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.k1, reason: use source file name */
/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorReplay2<T> implements Func0<OperatorReplay.e<T>> {
    public final /* synthetic */ int j;

    public OperatorReplay2(int i) {
        this.j = i;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public Object call() {
        return new OperatorReplay.g(this.j);
    }
}
