package d0.e0.p.d.m0.b;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.p.c$a;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.w0;
import d0.t.g0;
import d0.t.h0;
import d0.t.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: functionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final j0 createFunctionType(h hVar, d0.e0.p.d.m0.c.g1.g gVar, c0 c0Var, List<? extends c0> list, List<d0.e0.p.d.m0.g.e> list2, c0 c0Var2, boolean z2) {
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(list, "parameterTypes");
        d0.z.d.m.checkNotNullParameter(c0Var2, "returnType");
        List<w0> functionTypeArgumentProjections = getFunctionTypeArgumentProjections(c0Var, list, list2, c0Var2, hVar);
        int size = list.size();
        if (c0Var != null) {
            size++;
        }
        d0.e0.p.d.m0.c.e functionDescriptor = getFunctionDescriptor(hVar, size, z2);
        if (c0Var != null) {
            gVar = withExtensionFunctionAnnotation(gVar, hVar);
        }
        d0 d0Var = d0.a;
        return d0.simpleNotNullType(gVar, functionDescriptor, functionTypeArgumentProjections);
    }

    public static /* synthetic */ j0 createFunctionType$default(h hVar, d0.e0.p.d.m0.c.g1.g gVar, c0 c0Var, List list, List list2, c0 c0Var2, boolean z2, int i, Object obj) {
        return createFunctionType(hVar, gVar, c0Var, list, list2, c0Var2, (i & 64) != 0 ? false : z2);
    }

    public static final d0.e0.p.d.m0.g.e extractParameterNameFromFunctionTypeArgument(c0 c0Var) {
        String value;
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.e0.p.d.m0.c.g1.c cVarFindAnnotation = c0Var.getAnnotations().findAnnotation(k$a.f3229y);
        if (cVarFindAnnotation == null) {
            return null;
        }
        Object objSingleOrNull = u.singleOrNull(cVarFindAnnotation.getAllValueArguments().values());
        w wVar = objSingleOrNull instanceof w ? (w) objSingleOrNull : null;
        if (wVar == null || (value = wVar.getValue()) == null || !d0.e0.p.d.m0.g.e.isValidIdentifier(value)) {
            value = null;
        }
        if (value == null) {
            return null;
        }
        return d0.e0.p.d.m0.g.e.identifier(value);
    }

    public static final d0.e0.p.d.m0.c.e getFunctionDescriptor(h hVar, int i, boolean z2) {
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
        d0.e0.p.d.m0.c.e suspendFunction = z2 ? hVar.getSuspendFunction(i) : hVar.getFunction(i);
        d0.z.d.m.checkNotNullExpressionValue(suspendFunction, "if (isSuspendFunction) builtIns.getSuspendFunction(parameterCount) else builtIns.getFunction(parameterCount)");
        return suspendFunction;
    }

    public static final List<w0> getFunctionTypeArgumentProjections(c0 c0Var, List<? extends c0> list, List<d0.e0.p.d.m0.g.e> list2, c0 c0Var2, h hVar) {
        d0.e0.p.d.m0.g.e eVar;
        d0.z.d.m.checkNotNullParameter(list, "parameterTypes");
        d0.z.d.m.checkNotNullParameter(c0Var2, "returnType");
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
        int i = 0;
        ArrayList arrayList = new ArrayList(list.size() + (c0Var != null ? 1 : 0) + 1);
        d0.e0.p.d.m0.p.a.addIfNotNull(arrayList, c0Var == null ? null : d0.e0.p.d.m0.n.o1.a.asTypeProjection(c0Var));
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            c0 c0VarReplaceAnnotations = (c0) obj;
            if (list2 == null || (eVar = list2.get(i)) == null || eVar.isSpecial()) {
                eVar = null;
            }
            if (eVar != null) {
                d0.e0.p.d.m0.g.b bVar = k$a.f3229y;
                d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(ModelAuditLogEntry.CHANGE_KEY_NAME);
                String strAsString = eVar.asString();
                d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
                c0VarReplaceAnnotations = d0.e0.p.d.m0.n.o1.a.replaceAnnotations(c0VarReplaceAnnotations, d0.e0.p.d.m0.c.g1.g.f.create(u.plus(c0VarReplaceAnnotations.getAnnotations(), new d0.e0.p.d.m0.c.g1.j(hVar, bVar, g0.mapOf(d0.o.to(eVarIdentifier, new w(strAsString)))))));
            }
            arrayList.add(d0.e0.p.d.m0.n.o1.a.asTypeProjection(c0VarReplaceAnnotations));
            i = i2;
        }
        arrayList.add(d0.e0.p.d.m0.n.o1.a.asTypeProjection(c0Var2));
        return arrayList;
    }

    public static final d0.e0.p.d.m0.b.p.c getFunctionalClassKind(d0.e0.p.d.m0.c.m mVar) {
        d0.z.d.m.checkNotNullParameter(mVar, "<this>");
        if (!(mVar instanceof d0.e0.p.d.m0.c.e) || !h.isUnderKotlinPackage(mVar)) {
            return null;
        }
        d0.e0.p.d.m0.g.c fqNameUnsafe = d0.e0.p.d.m0.k.x.a.getFqNameUnsafe(mVar);
        if (!fqNameUnsafe.isSafe() || fqNameUnsafe.isRoot()) {
            return null;
        }
        c$a c_a = d0.e0.p.d.m0.b.p.c.j;
        String strAsString = fqNameUnsafe.shortName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "shortName().asString()");
        d0.e0.p.d.m0.g.b bVarParent = fqNameUnsafe.toSafe().parent();
        d0.z.d.m.checkNotNullExpressionValue(bVarParent, "toSafe().parent()");
        return c_a.getFunctionalClassKind(strAsString, bVarParent);
    }

    public static final c0 getReceiverTypeFromFunctionType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        isBuiltinFunctionalType(c0Var);
        if (c0Var.getAnnotations().findAnnotation(k$a.f3228x) != null) {
            return ((w0) u.first((List) c0Var.getArguments())).getType();
        }
        return null;
    }

    public static final c0 getReturnTypeFromFunctionType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        isBuiltinFunctionalType(c0Var);
        c0 type = ((w0) u.last((List) c0Var.getArguments())).getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "arguments.last().type");
        return type;
    }

    public static final List<w0> getValueParameterTypesFromFunctionType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        isBuiltinFunctionalType(c0Var);
        List<w0> arguments = c0Var.getArguments();
        return arguments.subList(isBuiltinExtensionFunctionalType(c0Var) ? 1 : 0, arguments.size() - 1);
    }

    public static final boolean isBuiltinExtensionFunctionalType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        if (isBuiltinFunctionalType(c0Var)) {
            return c0Var.getAnnotations().findAnnotation(k$a.f3228x) != null;
        }
        return false;
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(d0.e0.p.d.m0.c.m mVar) {
        d0.z.d.m.checkNotNullParameter(mVar, "<this>");
        d0.e0.p.d.m0.b.p.c functionalClassKind = getFunctionalClassKind(mVar);
        return functionalClassKind == d0.e0.p.d.m0.b.p.c.k || functionalClassKind == d0.e0.p.d.m0.b.p.c.l;
    }

    public static final boolean isBuiltinFunctionalType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        return d0.z.d.m.areEqual(declarationDescriptor == null ? null : Boolean.valueOf(isBuiltinFunctionalClassDescriptor(declarationDescriptor)), Boolean.TRUE);
    }

    public static final boolean isFunctionType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : getFunctionalClassKind(declarationDescriptor)) == d0.e0.p.d.m0.b.p.c.k;
    }

    public static final boolean isSuspendFunctionType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : getFunctionalClassKind(declarationDescriptor)) == d0.e0.p.d.m0.b.p.c.l;
    }

    public static final d0.e0.p.d.m0.c.g1.g withExtensionFunctionAnnotation(d0.e0.p.d.m0.c.g1.g gVar, h hVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "<this>");
        d0.z.d.m.checkNotNullParameter(hVar, "builtIns");
        d0.e0.p.d.m0.g.b bVar = k$a.f3228x;
        return gVar.hasAnnotation(bVar) ? gVar : d0.e0.p.d.m0.c.g1.g.f.create(u.plus(gVar, new d0.e0.p.d.m0.c.g1.j(hVar, bVar, h0.emptyMap())));
    }
}
