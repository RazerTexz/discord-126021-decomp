package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LazyJavaTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends d0.e0.p.d.m0.c.i1.b {
    public final d0.e0.p.d.m0.e.a.i0.g t;
    public final y u;
    public final d0.e0.p.d.m0.e.a.i0.d v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(d0.e0.p.d.m0.e.a.i0.g gVar, y yVar, int i, d0.e0.p.d.m0.c.m mVar) {
        super(gVar.getStorageManager(), mVar, yVar.getName(), j1.INVARIANT, false, i, u0.a, gVar.getComponents().getSupertypeLoopChecker());
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(yVar, "javaTypeParameter");
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        this.t = gVar;
        this.u = yVar;
        this.v = new d0.e0.p.d.m0.e.a.i0.d(gVar, yVar, false, 4, null);
    }

    @Override // d0.e0.p.d.m0.c.i1.f
    public List<c0> b(List<? extends c0> list) {
        d0.z.d.m.checkNotNullParameter(list, "bounds");
        return this.t.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, list, this.t);
    }

    @Override // d0.e0.p.d.m0.c.i1.f
    public void c(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
    }

    @Override // d0.e0.p.d.m0.c.i1.f
    public List<c0> d() {
        Collection<d0.e0.p.d.m0.e.a.k0.j> upperBounds = this.u.getUpperBounds();
        if (upperBounds.isEmpty()) {
            d0 d0Var = d0.a;
            j0 anyType = this.t.getModule().getBuiltIns().getAnyType();
            d0.z.d.m.checkNotNullExpressionValue(anyType, "c.module.builtIns.anyType");
            j0 nullableAnyType = this.t.getModule().getBuiltIns().getNullableAnyType();
            d0.z.d.m.checkNotNullExpressionValue(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return d0.t.m.listOf(d0.flexibleType(anyType, nullableAnyType));
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(this.t.getTypeResolver().transformJavaType((d0.e0.p.d.m0.e.a.k0.j) it.next(), d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.g1.b, d0.e0.p.d.m0.c.g1.a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return getAnnotations();
    }

    @Override // d0.e0.p.d.m0.c.g1.b, d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.e.a.i0.d getAnnotations() {
        return this.v;
    }
}
