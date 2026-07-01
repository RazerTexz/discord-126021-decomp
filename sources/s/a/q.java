package s.a;

import b.d.b.a.outline;
import kotlin.Unit;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends e1<h1> implements Job4 {
    public final Job6 n;

    public q(h1 h1Var, Job6 job6) {
        super(h1Var);
        this.n = job6;
    }

    @Override // s.a.Job4
    public boolean h(Throwable th) {
        return ((h1) this.m).E(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        q(th);
        return Unit.a;
    }

    @Override // s.a.CompletionHandler2
    public void q(Throwable th) {
        this.n.s((Job5) this.m);
    }

    @Override // s.a.a.LockFreeLinkedList3
    public String toString() {
        StringBuilder sbU = outline.U("ChildHandle[");
        sbU.append(this.n);
        sbU.append(']');
        return sbU.toString();
    }
}
