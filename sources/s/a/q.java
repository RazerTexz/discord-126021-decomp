package s.a;

import b.d.b.a.a;
import kotlin.Unit;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends e1<h1> implements p {
    public final r n;

    public q(h1 h1Var, r rVar) {
        super(h1Var);
        this.n = rVar;
    }

    @Override // s.a.p
    public boolean h(Throwable th) {
        return ((h1) this.m).E(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        q(th);
        return Unit.a;
    }

    @Override // s.a.y
    public void q(Throwable th) {
        this.n.s((q1) this.m);
    }

    @Override // s.a.a.k
    public String toString() {
        StringBuilder sbU = a.U("ChildHandle[");
        sbU.append(this.n);
        sbU.append(']');
        return sbU.toString();
    }
}
