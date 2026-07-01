package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.n.e1;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a$a implements Function1<d0.e0.p.d.m0.n.l1.g, d0.e0.p.d.m0.n.j0> {
    public final /* synthetic */ a$a j;

    public a$a$a(a$a a_a) {
        this.j = a_a;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.j0 invoke(d0.e0.p.d.m0.n.l1.g gVar) {
        return invoke2(gVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public d0.e0.p.d.m0.n.j0 invoke2(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.e0.p.d.m0.c.h hVarRefineDescriptor = gVar.refineDescriptor(this.j.j);
        if (hVarRefineDescriptor == null) {
            return this.j.j.l.invoke();
        }
        if (hVarRefineDescriptor instanceof y0) {
            return d0.e0.p.d.m0.n.d0.computeExpandedType((y0) hVarRefineDescriptor, e1.getDefaultTypeProjections(hVarRefineDescriptor.getTypeConstructor().getParameters()));
        }
        return hVarRefineDescriptor instanceof u ? e1.makeUnsubstitutedType(hVarRefineDescriptor.getTypeConstructor().refine(gVar), ((u) hVarRefineDescriptor).getUnsubstitutedMemberScope(gVar), this) : hVarRefineDescriptor.getDefaultType();
    }
}
