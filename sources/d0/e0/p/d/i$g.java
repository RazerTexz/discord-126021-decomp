package d0.e0.p.d;

import kotlin.Unit;

/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$g extends a {
    public i$g(i iVar, i iVar2) {
        super(iVar2);
    }

    @Override // d0.e0.p.d.m0.c.i1.m, d0.e0.p.d.m0.c.o
    public /* bridge */ /* synthetic */ Object visitConstructorDescriptor(d0.e0.p.d.m0.c.l lVar, Object obj) {
        return visitConstructorDescriptor(lVar, (Unit) obj);
    }

    public f<?> visitConstructorDescriptor(d0.e0.p.d.m0.c.l lVar, Unit unit) {
        d0.z.d.m.checkNotNullParameter(lVar, "descriptor");
        d0.z.d.m.checkNotNullParameter(unit, "data");
        throw new IllegalStateException("No constructors should appear here: " + lVar);
    }
}
