package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.u0;

/* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b implements d0.e0.p.d.m0.n.l1.f$a {
    public final /* synthetic */ b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3467b;
    public final /* synthetic */ d0.e0.p.d.m0.c.a c;
    public final /* synthetic */ d0.e0.p.d.m0.c.a d;

    public b$b(b bVar, boolean z2, d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2) {
        this.a = bVar;
        this.f3467b = z2;
        this.c = aVar;
        this.d = aVar2;
    }

    @Override // d0.e0.p.d.m0.n.l1.f$a
    public final boolean equals(u0 u0Var, u0 u0Var2) {
        d0.z.d.m.checkNotNullParameter(u0Var, "c1");
        d0.z.d.m.checkNotNullParameter(u0Var2, "c2");
        if (d0.z.d.m.areEqual(u0Var, u0Var2)) {
            return true;
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = u0Var.getDeclarationDescriptor();
        d0.e0.p.d.m0.c.h declarationDescriptor2 = u0Var2.getDeclarationDescriptor();
        if ((declarationDescriptor instanceof z0) && (declarationDescriptor2 instanceof z0)) {
            return b.access$areTypeParametersEquivalent(this.a, (z0) declarationDescriptor, (z0) declarationDescriptor2, this.f3467b, new b$b$a(this.c, this.d));
        }
        return false;
    }
}
