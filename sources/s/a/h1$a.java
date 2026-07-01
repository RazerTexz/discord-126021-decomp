package s.a;

import b.d.b.a.a;
import kotlin.Unit;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h1$a extends g1<Job> {
    public final h1 n;
    public final h1$b o;
    public final q p;
    public final Object q;

    public h1$a(h1 h1Var, h1$b h1_b, q qVar, Object obj) {
        super(qVar.n);
        this.n = h1Var;
        this.o = h1_b;
        this.p = qVar;
        this.q = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        q(th);
        return Unit.a;
    }

    @Override // s.a.y
    public void q(Throwable th) {
        h1 h1Var = this.n;
        h1$b h1_b = this.o;
        q qVar = this.p;
        Object obj = this.q;
        q qVarU = h1Var.U(qVar);
        if (qVarU == null || !h1Var.d0(h1_b, qVarU, obj)) {
            h1Var.v(h1Var.H(h1_b, obj));
        }
    }

    @Override // s.a.a.k
    public String toString() {
        StringBuilder sbU = a.U("ChildCompletion[");
        sbU.append(this.p);
        sbU.append(", ");
        sbU.append(this.q);
        sbU.append(']');
        return sbU.toString();
    }
}
