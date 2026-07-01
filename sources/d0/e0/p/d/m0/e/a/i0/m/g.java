package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.k.a0.i;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.i0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.v;
import d0.e0.p.d.m0.n.w0;
import d0.g0.w;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends v implements i0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(j0 j0Var, j0 j0Var2) {
        super(j0Var, j0Var2);
        m.checkNotNullParameter(j0Var, "lowerBound");
        m.checkNotNullParameter(j0Var2, "upperBound");
        d0.e0.p.d.m0.n.l1.f.a.isSubtypeOf(j0Var, j0Var2);
    }

    public static final List<String> a(d0.e0.p.d.m0.j.c cVar, c0 c0Var) {
        List<w0> arguments = c0Var.getArguments();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            arrayList.add(cVar.renderTypeProjection((w0) it.next()));
        }
        return arrayList;
    }

    public static final String b(String str, String str2) {
        if (!w.contains$default((CharSequence) str, '<', false, 2, (Object) null)) {
            return str;
        }
        return w.substringBefore$default(str, '<', (String) null, 2, (Object) null) + '<' + str2 + '>' + w.substringAfterLast$default(str, '>', null, 2, null);
    }

    @Override // d0.e0.p.d.m0.n.v
    public j0 getDelegate() {
        return getLowerBound();
    }

    @Override // d0.e0.p.d.m0.n.v, d0.e0.p.d.m0.n.c0
    public i getMemberScope() {
        h declarationDescriptor = getConstructor().getDeclarationDescriptor();
        d0.e0.p.d.m0.c.e eVar = declarationDescriptor instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) declarationDescriptor : null;
        if (eVar == null) {
            throw new IllegalStateException(m.stringPlus("Incorrect classifier: ", getConstructor().getDeclarationDescriptor()).toString());
        }
        i memberScope = eVar.getMemberScope(f.f3341b);
        m.checkNotNullExpressionValue(memberScope, "classDescriptor.getMemberScope(RawSubstitution)");
        return memberScope;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.v
    public String render(d0.e0.p.d.m0.j.c cVar, d0.e0.p.d.m0.j.h hVar) {
        String str;
        String str2;
        m.checkNotNullParameter(cVar, "renderer");
        m.checkNotNullParameter(hVar, "options");
        String strRenderType = cVar.renderType(getLowerBound());
        String strRenderType2 = cVar.renderType(getUpperBound());
        if (hVar.getDebugMode()) {
            return "raw (" + strRenderType + ".." + strRenderType2 + ')';
        }
        if (getUpperBound().getArguments().isEmpty()) {
            return cVar.renderFlexibleType(strRenderType, strRenderType2, d0.e0.p.d.m0.n.o1.a.getBuiltIns(this));
        }
        List<String> listA = a(cVar, getLowerBound());
        List<String> listA2 = a(cVar, getUpperBound());
        String strJoinToString$default = u.joinToString$default(listA, ", ", null, null, 0, null, g$a.j, 30, null);
        List listZip = u.zip(listA, listA2);
        boolean z2 = false;
        if (!(listZip instanceof Collection) || !listZip.isEmpty()) {
            Iterator it = listZip.iterator();
            do {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                Pair pair = (Pair) it.next();
                str = (String) pair.getFirst();
                str2 = (String) pair.getSecond();
            } while (m.areEqual(str, w.removePrefix(str2, "out ")) || m.areEqual(str2, "*"));
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            strRenderType2 = b(strRenderType2, strJoinToString$default);
        }
        String strB = b(strRenderType, strJoinToString$default);
        return m.areEqual(strB, strRenderType2) ? strB : cVar.renderFlexibleType(strB, strRenderType2, d0.e0.p.d.m0.n.o1.a.getBuiltIns(this));
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public g makeNullableAsSpecified(boolean z2) {
        return new g(getLowerBound().makeNullableAsSpecified(z2), getUpperBound().makeNullableAsSpecified(z2));
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public g replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        m.checkNotNullParameter(gVar, "newAnnotations");
        return new g(getLowerBound().replaceAnnotations(gVar), getUpperBound().replaceAnnotations(gVar));
    }

    public g(j0 j0Var, j0 j0Var2, boolean z2) {
        super(j0Var, j0Var2);
        if (z2) {
            return;
        }
        d0.e0.p.d.m0.n.l1.f.a.isSubtypeOf(j0Var, j0Var2);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public v refine(d0.e0.p.d.m0.n.l1.g gVar) {
        m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return new g((j0) gVar.refineType(getLowerBound()), (j0) gVar.refineType(getUpperBound()), true);
    }
}
