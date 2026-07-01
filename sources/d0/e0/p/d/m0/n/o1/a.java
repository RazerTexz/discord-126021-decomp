package d0.e0.p.d.m0.n.o1;

import d0.e0.p.d.m0.b.h;
import d0.e0.p.d.m0.c.e;
import d0.e0.p.d.m0.c.f;
import d0.e0.p.d.m0.c.g1.g;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.a1;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.g1;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.o0;
import d0.e0.p.d.m0.n.v;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TypeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final w0 asTypeProjection(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        return new y0(c0Var);
    }

    public static final boolean contains(c0 c0Var, Function1<? super i1, Boolean> function1) {
        m.checkNotNullParameter(c0Var, "<this>");
        m.checkNotNullParameter(function1, "predicate");
        return e1.contains(c0Var, function1);
    }

    public static final boolean containsTypeAliasParameters(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        return contains(c0Var, a$a.j);
    }

    public static final w0 createProjection(c0 c0Var, j1 j1Var, z0 z0Var) {
        m.checkNotNullParameter(c0Var, "type");
        m.checkNotNullParameter(j1Var, "projectionKind");
        if ((z0Var == null ? null : z0Var.getVariance()) == j1Var) {
            j1Var = j1.INVARIANT;
        }
        return new y0(j1Var, c0Var);
    }

    public static final h getBuiltIns(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        h builtIns = c0Var.getConstructor().getBuiltIns();
        m.checkNotNullExpressionValue(builtIns, "constructor.builtIns");
        return builtIns;
    }

    public static final c0 getRepresentativeUpperBound(z0 z0Var) {
        Object obj;
        m.checkNotNullParameter(z0Var, "<this>");
        List<c0> upperBounds = z0Var.getUpperBounds();
        m.checkNotNullExpressionValue(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List<c0> upperBounds2 = z0Var.getUpperBounds();
        m.checkNotNullExpressionValue(upperBounds2, "upperBounds");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            d0.e0.p.d.m0.c.h declarationDescriptor = ((c0) next).getConstructor().getDeclarationDescriptor();
            e eVar = declarationDescriptor instanceof e ? (e) declarationDescriptor : null;
            boolean z2 = false;
            if (eVar != null && eVar.getKind() != f.INTERFACE && eVar.getKind() != f.ANNOTATION_CLASS) {
                z2 = true;
            }
            if (z2) {
                obj = next;
                break;
            }
        }
        c0 c0Var = (c0) obj;
        if (c0Var != null) {
            return c0Var;
        }
        List<c0> upperBounds3 = z0Var.getUpperBounds();
        m.checkNotNullExpressionValue(upperBounds3, "upperBounds");
        Object objFirst = u.first((List<? extends Object>) upperBounds3);
        m.checkNotNullExpressionValue(objFirst, "upperBounds.first()");
        return (c0) objFirst;
    }

    public static final boolean isSubtypeOf(c0 c0Var, c0 c0Var2) {
        m.checkNotNullParameter(c0Var, "<this>");
        m.checkNotNullParameter(c0Var2, "superType");
        return d0.e0.p.d.m0.n.l1.f.a.isSubtypeOf(c0Var, c0Var2);
    }

    public static final boolean isTypeAliasParameter(d0.e0.p.d.m0.c.h hVar) {
        m.checkNotNullParameter(hVar, "<this>");
        return (hVar instanceof z0) && (((z0) hVar).getContainingDeclaration() instanceof d0.e0.p.d.m0.c.y0);
    }

    public static final boolean isTypeParameter(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        return e1.isTypeParameter(c0Var);
    }

    public static final c0 makeNotNullable(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        c0 c0VarMakeNotNullable = e1.makeNotNullable(c0Var);
        m.checkNotNullExpressionValue(c0VarMakeNotNullable, "makeNotNullable(this)");
        return c0VarMakeNotNullable;
    }

    public static final c0 makeNullable(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        c0 c0VarMakeNullable = e1.makeNullable(c0Var);
        m.checkNotNullExpressionValue(c0VarMakeNullable, "makeNullable(this)");
        return c0VarMakeNullable;
    }

    public static final c0 replaceAnnotations(c0 c0Var, g gVar) {
        m.checkNotNullParameter(c0Var, "<this>");
        m.checkNotNullParameter(gVar, "newAnnotations");
        return (c0Var.getAnnotations().isEmpty() && gVar.isEmpty()) ? c0Var : c0Var.unwrap().replaceAnnotations(gVar);
    }

    public static final c0 replaceArgumentsWithStarProjections(c0 c0Var) {
        j0 j0Var;
        i1 i1VarReplace$default;
        m.checkNotNullParameter(c0Var, "<this>");
        i1 i1VarUnwrap = c0Var.unwrap();
        if (i1VarUnwrap instanceof v) {
            d0 d0Var = d0.a;
            v vVar = (v) i1VarUnwrap;
            j0 lowerBound = vVar.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().getDeclarationDescriptor() != null) {
                List<z0> parameters = lowerBound.getConstructor().getParameters();
                m.checkNotNullExpressionValue(parameters, "constructor.parameters");
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new o0((z0) it.next()));
                }
                lowerBound = a1.replace$default(lowerBound, arrayList, null, 2, null);
            }
            j0 upperBound = vVar.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().getDeclarationDescriptor() != null) {
                List<z0> parameters2 = upperBound.getConstructor().getParameters();
                m.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(parameters2, 10));
                Iterator<T> it2 = parameters2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new o0((z0) it2.next()));
                }
                upperBound = a1.replace$default(upperBound, arrayList2, null, 2, null);
            }
            i1VarReplace$default = d0.flexibleType(lowerBound, upperBound);
        } else {
            if (!(i1VarUnwrap instanceof j0)) {
                throw new NoWhenBranchMatchedException();
            }
            j0Var = (j0) i1VarUnwrap;
            if (!j0Var.getConstructor().getParameters().isEmpty() && j0Var.getConstructor().getDeclarationDescriptor() != null) {
                i1VarReplace$default = j0Var;
                i1VarReplace$default = j0Var;
                List<z0> parameters3 = j0Var.getConstructor().getParameters();
                m.checkNotNullExpressionValue(parameters3, "constructor.parameters");
                ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(parameters3, 10));
                Iterator<T> it3 = parameters3.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new o0((z0) it3.next()));
                }
                i1VarReplace$default = a1.replace$default(j0Var, arrayList3, null, 2, null);
            }
        }
        i1VarReplace$default = j0Var;
        i1VarReplace$default = j0Var;
        i1VarReplace$default = j0Var;
        return g1.inheritEnhancement(i1VarReplace$default, i1VarUnwrap);
    }

    public static final boolean requiresTypeAliasExpansion(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        return contains(c0Var, a$b.j);
    }
}
