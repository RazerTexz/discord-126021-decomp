package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.a0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.g1;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements l {
    public final g c;
    public final d0.e0.p.d.m0.k.k d;

    public m(g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        this.c = gVar;
        d0.e0.p.d.m0.k.k kVarCreateWithTypeRefiner = d0.e0.p.d.m0.k.k.createWithTypeRefiner(getKotlinTypeRefiner());
        d0.z.d.m.checkNotNullExpressionValue(kVarCreateWithTypeRefiner, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.d = kVarCreateWithTypeRefiner;
    }

    @Override // d0.e0.p.d.m0.n.l1.f
    public boolean equalTypes(c0 c0Var, c0 c0Var2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "a");
        d0.z.d.m.checkNotNullParameter(c0Var2, "b");
        return equalTypes(new a(false, false, false, getKotlinTypeRefiner(), 6, null), c0Var.unwrap(), c0Var2.unwrap());
    }

    @Override // d0.e0.p.d.m0.n.l1.l
    public g getKotlinTypeRefiner() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.n.l1.l
    public d0.e0.p.d.m0.k.k getOverridingUtil() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.n.l1.f
    public boolean isSubtypeOf(c0 c0Var, c0 c0Var2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "subtype");
        d0.z.d.m.checkNotNullParameter(c0Var2, "supertype");
        return isSubtypeOf(new a(true, false, false, getKotlinTypeRefiner(), 6, null), c0Var.unwrap(), c0Var2.unwrap());
    }

    public final j0 transformToNewType(j0 j0Var) {
        c0 type;
        d0.z.d.m.checkNotNullParameter(j0Var, "type");
        u0 constructor = j0Var.getConstructor();
        boolean z2 = false;
        a0 alternative = null;
        i1VarUnwrap = null;
        i1 i1VarUnwrap = null;
        if (constructor instanceof d0.e0.p.d.m0.k.u.a.c) {
            d0.e0.p.d.m0.k.u.a.c cVar = (d0.e0.p.d.m0.k.u.a.c) constructor;
            w0 projection = cVar.getProjection();
            if (!(projection.getProjectionKind() == j1.IN_VARIANCE)) {
                projection = null;
            }
            if (projection != null && (type = projection.getType()) != null) {
                i1VarUnwrap = type.unwrap();
            }
            i1 i1Var = i1VarUnwrap;
            if (cVar.getNewTypeConstructor() == null) {
                w0 projection2 = cVar.getProjection();
                Collection<c0> supertypes = cVar.getSupertypes();
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(supertypes, 10));
                Iterator<T> it = supertypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(((c0) it.next()).unwrap());
                }
                cVar.setNewTypeConstructor(new j(projection2, arrayList, null, 4, null));
            }
            d0.e0.p.d.m0.n.n1.b bVar = d0.e0.p.d.m0.n.n1.b.FOR_SUBTYPING;
            j newTypeConstructor = cVar.getNewTypeConstructor();
            d0.z.d.m.checkNotNull(newTypeConstructor);
            return new i(bVar, newTypeConstructor, i1Var, j0Var.getAnnotations(), j0Var.isMarkedNullable(), false, 32, null);
        }
        if (constructor instanceof d0.e0.p.d.m0.k.v.q) {
            Collection<c0> supertypes2 = ((d0.e0.p.d.m0.k.v.q) constructor).getSupertypes();
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(supertypes2, 10));
            Iterator<T> it2 = supertypes2.iterator();
            while (it2.hasNext()) {
                c0 c0VarMakeNullableAsSpecified = e1.makeNullableAsSpecified((c0) it2.next(), j0Var.isMarkedNullable());
                d0.z.d.m.checkNotNullExpressionValue(c0VarMakeNullableAsSpecified, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(c0VarMakeNullableAsSpecified);
            }
            a0 a0Var = new a0(arrayList2);
            d0 d0Var = d0.a;
            return d0.simpleTypeWithNonTrivialMemberScope(j0Var.getAnnotations(), a0Var, d0.t.n.emptyList(), false, j0Var.getMemberScope());
        }
        if (!(constructor instanceof a0) || !j0Var.isMarkedNullable()) {
            return j0Var;
        }
        a0 a0Var2 = (a0) constructor;
        Collection<c0> supertypes3 = a0Var2.getSupertypes();
        ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(supertypes3, 10));
        Iterator<T> it3 = supertypes3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(d0.e0.p.d.m0.n.o1.a.makeNullable((c0) it3.next()));
            z2 = true;
        }
        if (z2) {
            c0 alternativeType = a0Var2.getAlternativeType();
            alternative = new a0(arrayList3).setAlternative(alternativeType != null ? d0.e0.p.d.m0.n.o1.a.makeNullable(alternativeType) : null);
        }
        if (alternative != null) {
            a0Var2 = alternative;
        }
        return a0Var2.createType();
    }

    public final boolean equalTypes(a aVar, i1 i1Var, i1 i1Var2) {
        d0.z.d.m.checkNotNullParameter(aVar, "<this>");
        d0.z.d.m.checkNotNullParameter(i1Var, "a");
        d0.z.d.m.checkNotNullParameter(i1Var2, "b");
        return d0.e0.p.d.m0.n.e.a.equalTypes(aVar, i1Var, i1Var2);
    }

    public final boolean isSubtypeOf(a aVar, i1 i1Var, i1 i1Var2) {
        d0.z.d.m.checkNotNullParameter(aVar, "<this>");
        d0.z.d.m.checkNotNullParameter(i1Var, "subType");
        d0.z.d.m.checkNotNullParameter(i1Var2, "superType");
        return d0.e0.p.d.m0.n.e.isSubtypeOf$default(d0.e0.p.d.m0.n.e.a, aVar, i1Var, i1Var2, false, 8, null);
    }

    public i1 transformToNewType(i1 i1Var) {
        i1 i1VarFlexibleType;
        d0.z.d.m.checkNotNullParameter(i1Var, "type");
        if (i1Var instanceof j0) {
            i1VarFlexibleType = transformToNewType((j0) i1Var);
        } else if (i1Var instanceof d0.e0.p.d.m0.n.v) {
            d0.e0.p.d.m0.n.v vVar = (d0.e0.p.d.m0.n.v) i1Var;
            j0 j0VarTransformToNewType = transformToNewType(vVar.getLowerBound());
            j0 j0VarTransformToNewType2 = transformToNewType(vVar.getUpperBound());
            if (j0VarTransformToNewType == vVar.getLowerBound() && j0VarTransformToNewType2 == vVar.getUpperBound()) {
                i1VarFlexibleType = i1Var;
            } else {
                d0 d0Var = d0.a;
                i1VarFlexibleType = d0.flexibleType(j0VarTransformToNewType, j0VarTransformToNewType2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return g1.inheritEnhancement(i1VarFlexibleType, i1Var);
    }
}
