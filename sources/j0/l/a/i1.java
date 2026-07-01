package j0.l.a;

import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public class i1 implements Action0 {
    public final /* synthetic */ h1$b j;

    public i1(h1$b h1_b) {
        this.j = h1_b;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // rx.functions.Action0
    public void call() {
        this.j.o.getAndSet(h1$b.k);
        h1$b h1_b = this.j;
        h1_b.m.compareAndSet((h1$b<T>) h1_b, null);
    }
}
