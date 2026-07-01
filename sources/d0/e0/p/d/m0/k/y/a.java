package d0.e0.p.d.m0.k.y;

import d0.e0.p.d.m0.b.k;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.e;
import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.c.m;
import d0.e0.p.d.m0.c.t;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.k.g;
import d0.e0.p.d.m0.n.c0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: inlineClassManglingRules.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final boolean a(c0 c0Var) {
        h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        z0 z0Var = declarationDescriptor instanceof z0 ? (z0) declarationDescriptor : null;
        if (z0Var == null) {
            return false;
        }
        return b(d0.e0.p.d.m0.n.o1.a.getRepresentativeUpperBound(z0Var));
    }

    public static final boolean b(c0 c0Var) {
        return isInlineClassThatRequiresMangling(c0Var) || a(c0Var);
    }

    public static final boolean isInlineClassThatRequiresMangling(m mVar) {
        d0.z.d.m.checkNotNullParameter(mVar, "<this>");
        return g.isInlineClass(mVar) && !d0.z.d.m.areEqual(d0.e0.p.d.m0.k.x.a.getFqNameSafe((e) mVar), k.h);
    }

    public static final boolean shouldHideConstructorDueToInlineClassTypeValueParameters(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "descriptor");
        d0.e0.p.d.m0.c.d dVar = bVar instanceof d0.e0.p.d.m0.c.d ? (d0.e0.p.d.m0.c.d) bVar : null;
        if (dVar == null || t.isPrivate(dVar.getVisibility())) {
            return false;
        }
        e constructedClass = dVar.getConstructedClass();
        d0.z.d.m.checkNotNullExpressionValue(constructedClass, "constructorDescriptor.constructedClass");
        if (g.isInlineClass(constructedClass) || d0.e0.p.d.m0.k.e.isSealedClass(dVar.getConstructedClass())) {
            return false;
        }
        List<c1> valueParameters = dVar.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "constructorDescriptor.valueParameters");
        if ((valueParameters instanceof Collection) && valueParameters.isEmpty()) {
            return false;
        }
        Iterator<T> it = valueParameters.iterator();
        while (it.hasNext()) {
            c0 type = ((c1) it.next()).getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "it.type");
            if (b(type)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClassThatRequiresMangling(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        return d0.z.d.m.areEqual(declarationDescriptor == null ? null : Boolean.valueOf(isInlineClassThatRequiresMangling(declarationDescriptor)), Boolean.TRUE);
    }
}
