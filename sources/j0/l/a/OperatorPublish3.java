package j0.l.a;

import j0.l.a.OperatorPublish2;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.i1, reason: use source file name */
/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorPublish3 implements Action0 {
    public final /* synthetic */ OperatorPublish2.b j;

    public OperatorPublish3(OperatorPublish2.b bVar) {
        this.j = bVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // rx.functions.Action0
    public void call() {
        this.j.o.getAndSet(OperatorPublish2.b.k);
        OperatorPublish2.b bVar = this.j;
        bVar.m.compareAndSet((OperatorPublish2.b<T>) bVar, null);
    }
}
