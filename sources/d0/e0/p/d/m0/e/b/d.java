package d0.e0.p.d.m0.e.b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.o0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final String computeInternalName(d0.e0.p.d.m0.c.e eVar, x<?> xVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "klass");
        d0.z.d.m.checkNotNullParameter(xVar, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = xVar.getPredefinedFullInternalNameForClass(eVar);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        d0.e0.p.d.m0.c.m containingDeclaration = eVar.getContainingDeclaration();
        d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "klass.containingDeclaration");
        String identifier = d0.e0.p.d.m0.g.g.safeIdentifier(eVar.getName()).getIdentifier();
        d0.z.d.m.checkNotNullExpressionValue(identifier, "safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof e0) {
            d0.e0.p.d.m0.g.b fqName = ((e0) containingDeclaration).getFqName();
            if (fqName.isRoot()) {
                return identifier;
            }
            StringBuilder sb = new StringBuilder();
            String strAsString = fqName.asString();
            d0.z.d.m.checkNotNullExpressionValue(strAsString, "fqName.asString()");
            sb.append(d0.g0.t.replace$default(strAsString, '.', MentionUtilsKt.SLASH_CHAR, false, 4, (Object) null));
            sb.append(MentionUtilsKt.SLASH_CHAR);
            sb.append(identifier);
            return sb.toString();
        }
        d0.e0.p.d.m0.c.e eVar2 = containingDeclaration instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) containingDeclaration : null;
        if (eVar2 == null) {
            throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + eVar);
        }
        String predefinedInternalNameForClass = xVar.getPredefinedInternalNameForClass(eVar2);
        if (predefinedInternalNameForClass == null) {
            predefinedInternalNameForClass = computeInternalName(eVar2, xVar);
        }
        return predefinedInternalNameForClass + '$' + identifier;
    }

    public static /* synthetic */ String computeInternalName$default(d0.e0.p.d.m0.c.e eVar, x xVar, int i, Object obj) {
        if ((i & 2) != 0) {
            xVar = y.a;
        }
        return computeInternalName(eVar, xVar);
    }

    public static final boolean hasVoidReturnType(d0.e0.p.d.m0.c.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "descriptor");
        if (aVar instanceof d0.e0.p.d.m0.c.l) {
            return true;
        }
        c0 returnType = aVar.getReturnType();
        d0.z.d.m.checkNotNull(returnType);
        if (d0.e0.p.d.m0.b.h.isUnit(returnType)) {
            c0 returnType2 = aVar.getReturnType();
            d0.z.d.m.checkNotNull(returnType2);
            if (!e1.isNullableType(returnType2) && !(aVar instanceof o0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.lang.Object] */
    public static final <T> T mapType(c0 c0Var, l<T> lVar, z zVar, x<? extends T> xVar, i<T> iVar, Function3<? super c0, ? super T, ? super z, Unit> function3) {
        T t;
        c0 c0Var2;
        Object objMapType;
        d0.z.d.m.checkNotNullParameter(c0Var, "kotlinType");
        d0.z.d.m.checkNotNullParameter(lVar, "factory");
        d0.z.d.m.checkNotNullParameter(zVar, "mode");
        d0.z.d.m.checkNotNullParameter(xVar, "typeMappingConfiguration");
        d0.z.d.m.checkNotNullParameter(function3, "writeGenericType");
        c0 c0VarPreprocessType = xVar.preprocessType(c0Var);
        if (c0VarPreprocessType != null) {
            return (T) mapType(c0VarPreprocessType, lVar, zVar, xVar, iVar, function3);
        }
        if (d0.e0.p.d.m0.b.g.isSuspendFunctionType(c0Var)) {
            return (T) mapType(d0.e0.p.d.m0.b.l.transformSuspendFunctionToRuntimeFunctionType(c0Var, xVar.releaseCoroutines()), lVar, zVar, xVar, iVar, function3);
        }
        d0.e0.p.d.m0.n.l1.p pVar = d0.e0.p.d.m0.n.l1.p.a;
        Object objMapBuiltInType = a0.mapBuiltInType(pVar, c0Var, lVar, zVar);
        if (objMapBuiltInType != null) {
            ?? r11 = (Object) a0.boxTypeIfNeeded(lVar, objMapBuiltInType, zVar.getNeedPrimitiveBoxing());
            function3.invoke(c0Var, r11, zVar);
            return r11;
        }
        u0 constructor = c0Var.getConstructor();
        if (constructor instanceof d0.e0.p.d.m0.n.a0) {
            d0.e0.p.d.m0.n.a0 a0Var = (d0.e0.p.d.m0.n.a0) constructor;
            c0 alternativeType = a0Var.getAlternativeType();
            if (alternativeType == null) {
                alternativeType = xVar.commonSupertype(a0Var.getSupertypes());
            }
            return (T) mapType(d0.e0.p.d.m0.n.o1.a.replaceArgumentsWithStarProjections(alternativeType), lVar, zVar, xVar, iVar, function3);
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = constructor.getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            throw new UnsupportedOperationException(d0.z.d.m.stringPlus("no descriptor for type constructor of ", c0Var));
        }
        if (d0.e0.p.d.m0.n.t.isError(declarationDescriptor)) {
            T t2 = (T) lVar.createObjectType("error/NonExistentClass");
            xVar.processErrorType(c0Var, (d0.e0.p.d.m0.c.e) declarationDescriptor);
            if (iVar == null) {
                return t2;
            }
            throw null;
        }
        boolean z2 = declarationDescriptor instanceof d0.e0.p.d.m0.c.e;
        if (z2 && d0.e0.p.d.m0.b.h.isArray(c0Var)) {
            if (c0Var.getArguments().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            w0 w0Var = c0Var.getArguments().get(0);
            c0 type = w0Var.getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "memberProjection.type");
            if (w0Var.getProjectionKind() == j1.IN_VARIANCE) {
                objMapType = lVar.createObjectType("java/lang/Object");
                if (iVar != null) {
                    throw null;
                }
            } else {
                if (iVar != null) {
                    throw null;
                }
                j1 projectionKind = w0Var.getProjectionKind();
                d0.z.d.m.checkNotNullExpressionValue(projectionKind, "memberProjection.projectionKind");
                objMapType = mapType(type, lVar, zVar.toGenericArgumentMode(projectionKind, true), xVar, iVar, function3);
                if (iVar != null) {
                    throw null;
                }
            }
            return (T) lVar.createFromString(d0.z.d.m.stringPlus("[", lVar.toString(objMapType)));
        }
        if (!z2) {
            if (!(declarationDescriptor instanceof z0)) {
                if ((declarationDescriptor instanceof y0) && zVar.getMapTypeAliases()) {
                    return (T) mapType(((y0) declarationDescriptor).getExpandedType(), lVar, zVar, xVar, iVar, function3);
                }
                throw new UnsupportedOperationException(d0.z.d.m.stringPlus("Unknown type ", c0Var));
            }
            T t3 = (T) mapType(d0.e0.p.d.m0.n.o1.a.getRepresentativeUpperBound((z0) declarationDescriptor), lVar, zVar, xVar, null, d0.e0.p.d.m0.p.d.getDO_NOTHING_3());
            if (iVar == null) {
                return t3;
            }
            d0.z.d.m.checkNotNullExpressionValue(declarationDescriptor.getName(), "descriptor.getName()");
            throw null;
        }
        if (d0.e0.p.d.m0.k.g.isInlineClass(declarationDescriptor) && !zVar.getNeedInlineClassWrapping() && (c0Var2 = (c0) d0.e0.p.d.m0.n.u.computeExpandedTypeForInlineClass(pVar, c0Var)) != null) {
            return (T) mapType(c0Var2, lVar, zVar.wrapInlineClassesMode(), xVar, iVar, function3);
        }
        if (zVar.isForAnnotationParameter() && d0.e0.p.d.m0.b.h.isKClass((d0.e0.p.d.m0.c.e) declarationDescriptor)) {
            t = (Object) lVar.getJavaLangClassType();
        } else {
            d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) declarationDescriptor;
            d0.e0.p.d.m0.c.e original = eVar.getOriginal();
            d0.z.d.m.checkNotNullExpressionValue(original, "descriptor.original");
            T predefinedTypeForClass = xVar.getPredefinedTypeForClass(original);
            if (predefinedTypeForClass == null) {
                if (eVar.getKind() == d0.e0.p.d.m0.c.f.ENUM_ENTRY) {
                    eVar = (d0.e0.p.d.m0.c.e) eVar.getContainingDeclaration();
                }
                d0.e0.p.d.m0.c.e original2 = eVar.getOriginal();
                d0.z.d.m.checkNotNullExpressionValue(original2, "enumClassIfEnumEntry.original");
                t = (Object) lVar.createObjectType(computeInternalName(original2, xVar));
            } else {
                t = (Object) predefinedTypeForClass;
            }
        }
        function3.invoke(c0Var, t, zVar);
        return t;
    }

    public static /* synthetic */ Object mapType$default(c0 c0Var, l lVar, z zVar, x xVar, i iVar, Function3 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = d0.e0.p.d.m0.p.d.getDO_NOTHING_3();
        }
        return mapType(c0Var, lVar, zVar, xVar, iVar, function3);
    }
}
