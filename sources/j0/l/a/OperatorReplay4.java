package j0.l.a;

import j0.l.a.OperatorReplay;
import j0.l.e.OpenHashSet;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.m1, reason: use source file name */
/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorReplay4 implements Action0 {
    public final /* synthetic */ OperatorReplay.f j;

    public OperatorReplay4(OperatorReplay.f fVar) {
        this.j = fVar;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T[], java.lang.Object[]] */
    @Override // rx.functions.Action0
    public void call() {
        if (this.j.m) {
            return;
        }
        synchronized (this.j.n) {
            if (!this.j.m) {
                OperatorReplay.f fVar = this.j;
                OpenHashSet<OperatorReplay.c<T>> openHashSet = fVar.n;
                openHashSet.f3794b = 0;
                openHashSet.d = new Object[0];
                fVar.p++;
                this.j.m = true;
            }
        }
    }
}
