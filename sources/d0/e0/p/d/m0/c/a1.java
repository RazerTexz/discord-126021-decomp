package d0.e0.p.d.m0.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a1 {
    public static final l0 a(d0.e0.p.d.m0.n.c0 c0Var, i iVar, int i) {
        if (iVar == null || d0.e0.p.d.m0.n.t.isError(iVar)) {
            return null;
        }
        int size = iVar.getDeclaredTypeParameters().size() + i;
        if (iVar.isInner()) {
            List<d0.e0.p.d.m0.n.w0> listSubList = c0Var.getArguments().subList(i, size);
            m containingDeclaration = iVar.getContainingDeclaration();
            return new l0(iVar, listSubList, a(c0Var, containingDeclaration instanceof i ? (i) containingDeclaration : null, size));
        }
        if (size != c0Var.getArguments().size()) {
            d0.e0.p.d.m0.k.e.isLocal(iVar);
        }
        return new l0(iVar, c0Var.getArguments().subList(i, c0Var.getArguments().size()), null);
    }

    public static final l0 buildPossiblyInnerType(d0.e0.p.d.m0.n.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        return a(c0Var, declarationDescriptor instanceof i ? (i) declarationDescriptor : null, 0);
    }

    public static final List<z0> computeConstructorTypeParameters(i iVar) {
        List<z0> listEmptyList;
        m next;
        d0.e0.p.d.m0.n.u0 typeConstructor;
        d0.z.d.m.checkNotNullParameter(iVar, "<this>");
        List<z0> declaredTypeParameters = iVar.getDeclaredTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(declaredTypeParameters, "declaredTypeParameters");
        if (!iVar.isInner() && !(iVar.getContainingDeclaration() instanceof a)) {
            return declaredTypeParameters;
        }
        List list = d0.f0.q.toList(d0.f0.q.flatMap(d0.f0.q.filter(d0.f0.q.takeWhile(d0.e0.p.d.m0.k.x.a.getParents(iVar), a1$a.j), a1$b.j), a1$c.j));
        Iterator<m> it = d0.e0.p.d.m0.k.x.a.getParents(iVar).iterator();
        do {
            listEmptyList = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof e));
        e eVar = (e) next;
        if (eVar != null && (typeConstructor = eVar.getTypeConstructor()) != null) {
            listEmptyList = typeConstructor.getParameters();
        }
        if (listEmptyList == null) {
            listEmptyList = d0.t.n.emptyList();
        }
        if (list.isEmpty() && listEmptyList.isEmpty()) {
            List<z0> declaredTypeParameters2 = iVar.getDeclaredTypeParameters();
            d0.z.d.m.checkNotNullExpressionValue(declaredTypeParameters2, "declaredTypeParameters");
            return declaredTypeParameters2;
        }
        List<z0> listPlus = d0.t.u.plus((Collection) list, (Iterable) listEmptyList);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listPlus, 10));
        for (z0 z0Var : listPlus) {
            d0.z.d.m.checkNotNullExpressionValue(z0Var, "it");
            arrayList.add(new c(z0Var, iVar, declaredTypeParameters.size()));
        }
        return d0.t.u.plus((Collection) declaredTypeParameters, (Iterable) arrayList);
    }
}
