package d0.e0.p.d.m0.k.u.a;

import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.l;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.z0;
import d0.z.d.m;

/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b extends l {
    public final /* synthetic */ boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$b(boolean z2, z0 z0Var) {
        super(z0Var);
        this.c = z2;
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean approximateContravariantCapturedTypes() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.n.l, d0.e0.p.d.m0.n.z0
    public w0 get(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "key");
        w0 w0Var = super.get(c0Var);
        if (w0Var == null) {
            return null;
        }
        h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        return d.access$createCapturedIfNeeded(w0Var, declarationDescriptor instanceof d0.e0.p.d.m0.c.z0 ? (d0.e0.p.d.m0.c.z0) declarationDescriptor : null);
    }
}
