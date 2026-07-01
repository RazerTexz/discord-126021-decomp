package d0.e0.p.d.m0.n;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p0$a extends v0 {
    public final /* synthetic */ List<u0> c;

    /* JADX WARN: Multi-variable type inference failed */
    public p0$a(List<? extends u0> list) {
        this.c = list;
    }

    @Override // d0.e0.p.d.m0.n.v0
    public w0 get(u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(u0Var, "key");
        if (!this.c.contains(u0Var)) {
            return null;
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = u0Var.getDeclarationDescriptor();
        Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        return e1.makeStarProjection((d0.e0.p.d.m0.c.z0) declarationDescriptor);
    }
}
