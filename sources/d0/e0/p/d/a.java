package d0.e0.p.d;

import d0.e0.p.d.m0.c.n0;
import kotlin.Unit;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a extends d0.e0.p.d.m0.c.i1.m<f<?>, Unit> {
    public final i a;

    public a(i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        this.a = iVar;
    }

    @Override // d0.e0.p.d.m0.c.i1.m, d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Object visitFunctionDescriptor(d0.e0.p.d.m0.c.x xVar, Object obj) {
        return visitFunctionDescriptor(xVar, (Unit) obj);
    }

    @Override // d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Object visitPropertyDescriptor(n0 n0Var, Object obj) {
        return visitPropertyDescriptor(n0Var, (Unit) obj);
    }

    public f<?> visitFunctionDescriptor(d0.e0.p.d.m0.c.x xVar, Unit unit) {
        d0.z.d.m.checkNotNullParameter(xVar, "descriptor");
        d0.z.d.m.checkNotNullParameter(unit, "data");
        return new j(this.a, xVar);
    }

    public f<?> visitPropertyDescriptor(n0 n0Var, Unit unit) {
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(unit, "data");
        int i = (n0Var.getDispatchReceiverParameter() != null ? 1 : 0) + (n0Var.getExtensionReceiverParameter() != null ? 1 : 0);
        if (n0Var.isVar()) {
            if (i == 0) {
                return new k(this.a, n0Var);
            }
            if (i == 1) {
                return new l(this.a, n0Var);
            }
            if (i == 2) {
                return new m(this.a, n0Var);
            }
        } else {
            if (i == 0) {
                return new p(this.a, n0Var);
            }
            if (i == 1) {
                return new q(this.a, n0Var);
            }
            if (i == 2) {
                return new r(this.a, n0Var);
            }
        }
        throw new a0("Unsupported property: " + n0Var);
    }
}
