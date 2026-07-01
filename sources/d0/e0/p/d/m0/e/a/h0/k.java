package d0.e0.p.d.m0.e.a.h0;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.i1.l0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.e.a.a0;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.n.c0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final List<c1> copyValueParameters(Collection<l> collection, Collection<? extends c1> collection2, d0.e0.p.d.m0.c.a aVar) {
        m.checkNotNullParameter(collection, "newValueParametersTypes");
        m.checkNotNullParameter(collection2, "oldValueParameters");
        m.checkNotNullParameter(aVar, "newOwner");
        collection.size();
        collection2.size();
        List<Pair> listZip = u.zip(collection, collection2);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listZip, 10));
        for (Pair pair : listZip) {
            l lVar = (l) pair.component1();
            c1 c1Var = (c1) pair.component2();
            int index = c1Var.getIndex();
            d0.e0.p.d.m0.c.g1.g annotations = c1Var.getAnnotations();
            d0.e0.p.d.m0.g.e name = c1Var.getName();
            m.checkNotNullExpressionValue(name, "oldParameter.name");
            c0 type = lVar.getType();
            boolean hasDefaultValue = lVar.getHasDefaultValue();
            boolean zIsCrossinline = c1Var.isCrossinline();
            boolean zIsNoinline = c1Var.isNoinline();
            c0 arrayElementType = c1Var.getVarargElementType() != null ? d0.e0.p.d.m0.k.x.a.getModule(aVar).getBuiltIns().getArrayElementType(lVar.getType()) : null;
            u0 source = c1Var.getSource();
            m.checkNotNullExpressionValue(source, "oldParameter.source");
            arrayList.add(new l0(aVar, null, index, annotations, name, type, hasDefaultValue, zIsCrossinline, zIsNoinline, arrayElementType, source));
        }
        return arrayList;
    }

    public static final a getDefaultValueFromAnnotation(c1 c1Var) {
        d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument;
        w wVar;
        String value;
        m.checkNotNullParameter(c1Var, "<this>");
        d0.e0.p.d.m0.c.g1.g annotations = c1Var.getAnnotations();
        d0.e0.p.d.m0.g.b bVar = a0.r;
        m.checkNotNullExpressionValue(bVar, "DEFAULT_VALUE_FQ_NAME");
        d0.e0.p.d.m0.c.g1.c cVarFindAnnotation = annotations.findAnnotation(bVar);
        if (cVarFindAnnotation == null || (gVarFirstArgument = d0.e0.p.d.m0.k.x.a.firstArgument(cVarFindAnnotation)) == null) {
            wVar = null;
        } else {
            if (!(gVarFirstArgument instanceof w)) {
                gVarFirstArgument = null;
            }
            wVar = (w) gVarFirstArgument;
        }
        if (wVar != null && (value = wVar.getValue()) != null) {
            return new j(value);
        }
        d0.e0.p.d.m0.c.g1.g annotations2 = c1Var.getAnnotations();
        d0.e0.p.d.m0.g.b bVar2 = a0.f3306s;
        m.checkNotNullExpressionValue(bVar2, "DEFAULT_NULL_FQ_NAME");
        if (annotations2.hasAnnotation(bVar2)) {
            return h.a;
        }
        return null;
    }

    public static final d0.e0.p.d.m0.e.a.i0.l.o getParentJavaStaticClassScope(d0.e0.p.d.m0.c.e eVar) {
        m.checkNotNullParameter(eVar, "<this>");
        d0.e0.p.d.m0.c.e superClassNotAny = d0.e0.p.d.m0.k.x.a.getSuperClassNotAny(eVar);
        if (superClassNotAny == null) {
            return null;
        }
        d0.e0.p.d.m0.k.a0.i staticScope = superClassNotAny.getStaticScope();
        d0.e0.p.d.m0.e.a.i0.l.o oVar = staticScope instanceof d0.e0.p.d.m0.e.a.i0.l.o ? (d0.e0.p.d.m0.e.a.i0.l.o) staticScope : null;
        return oVar == null ? getParentJavaStaticClassScope(superClassNotAny) : oVar;
    }
}
