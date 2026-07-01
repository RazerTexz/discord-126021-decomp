package s.a;

import b.d.b.a.a;
import kotlin.Unit;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends g1<Job> {
    public final m0 n;

    public o0(Job job, m0 m0Var) {
        super(job);
        this.n = m0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.n.dispose();
        return Unit.a;
    }

    @Override // s.a.y
    public void q(Throwable th) {
        this.n.dispose();
    }

    @Override // s.a.a.k
    public String toString() {
        StringBuilder sbU = a.U("DisposeOnCompletion[");
        sbU.append(this.n);
        sbU.append(']');
        return sbU.toString();
    }
}
