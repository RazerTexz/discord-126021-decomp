package p637j0.p642l.p643a;

import p637j0.p642l.p643a.C12636j1;
import p637j0.p642l.p647e.C12717g;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.m1 */
/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12648m1 implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12636j1.f f26911j;

    public C12648m1(C12636j1.f fVar) {
        this.f26911j = fVar;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T[], java.lang.Object[]] */
    @Override // p658rx.functions.Action0
    public void call() {
        if (this.f26911j.f26864m) {
            return;
        }
        synchronized (this.f26911j.f26865n) {
            if (!this.f26911j.f26864m) {
                C12636j1.f fVar = this.f26911j;
                C12717g<C12636j1.c<T>> c12717g = fVar.f26865n;
                c12717g.f27278b = 0;
                c12717g.f27280d = new Object[0];
                fVar.f26867p++;
                this.f26911j.f26864m = true;
            }
        }
    }
}
