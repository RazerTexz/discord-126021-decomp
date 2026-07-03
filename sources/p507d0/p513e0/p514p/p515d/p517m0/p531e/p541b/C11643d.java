package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11287g;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11292l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11455o0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11718g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11789g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11907a0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12007u;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11956p;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12036d;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.d */
/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11643d {
    public static final String computeInternalName(InterfaceC11330e interfaceC11330e, InterfaceC11663x<?> interfaceC11663x) {
        C12238m.checkNotNullParameter(interfaceC11330e, "klass");
        C12238m.checkNotNullParameter(interfaceC11663x, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = interfaceC11663x.getPredefinedFullInternalNameForClass(interfaceC11330e);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        InterfaceC11450m containingDeclaration = interfaceC11330e.getContainingDeclaration();
        C12238m.checkNotNullExpressionValue(containingDeclaration, "klass.containingDeclaration");
        String identifier = C11718g.safeIdentifier(interfaceC11330e.getName()).getIdentifier();
        C12238m.checkNotNullExpressionValue(identifier, "safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof InterfaceC11331e0) {
            C11713b fqName = ((InterfaceC11331e0) containingDeclaration).getFqName();
            if (fqName.isRoot()) {
                return identifier;
            }
            StringBuilder sb = new StringBuilder();
            String strAsString = fqName.asString();
            C12238m.checkNotNullExpressionValue(strAsString, "fqName.asString()");
            sb.append(C12103t.replace$default(strAsString, '.', MentionUtilsKt.SLASH_CHAR, false, 4, (Object) null));
            sb.append(MentionUtilsKt.SLASH_CHAR);
            sb.append(identifier);
            return sb.toString();
        }
        InterfaceC11330e interfaceC11330e2 = containingDeclaration instanceof InterfaceC11330e ? (InterfaceC11330e) containingDeclaration : null;
        if (interfaceC11330e2 == null) {
            throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + interfaceC11330e);
        }
        String predefinedInternalNameForClass = interfaceC11663x.getPredefinedInternalNameForClass(interfaceC11330e2);
        if (predefinedInternalNameForClass == null) {
            predefinedInternalNameForClass = computeInternalName(interfaceC11330e2, interfaceC11663x);
        }
        return predefinedInternalNameForClass + '$' + identifier;
    }

    public static /* synthetic */ String computeInternalName$default(InterfaceC11330e interfaceC11330e, InterfaceC11663x interfaceC11663x, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC11663x = C11664y.f23637a;
        }
        return computeInternalName(interfaceC11330e, interfaceC11663x);
    }

    public static final boolean hasVoidReturnType(InterfaceC11318a interfaceC11318a) {
        C12238m.checkNotNullParameter(interfaceC11318a, "descriptor");
        if (interfaceC11318a instanceof InterfaceC11448l) {
            return true;
        }
        AbstractC11913c0 returnType = interfaceC11318a.getReturnType();
        C12238m.checkNotNull(returnType);
        if (AbstractC11288h.isUnit(returnType)) {
            AbstractC11913c0 returnType2 = interfaceC11318a.getReturnType();
            C12238m.checkNotNull(returnType2);
            if (!C11920e1.isNullableType(returnType2) && !(interfaceC11318a instanceof InterfaceC11455o0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.lang.Object] */
    public static final <T> T mapType(AbstractC11913c0 abstractC11913c0, InterfaceC11651l<T> interfaceC11651l, C11665z c11665z, InterfaceC11663x<? extends T> interfaceC11663x, C11648i<T> c11648i, Function3<? super AbstractC11913c0, ? super T, ? super C11665z, Unit> function3) {
        T t;
        AbstractC11913c0 abstractC11913c1;
        Object objMapType;
        C12238m.checkNotNullParameter(abstractC11913c0, "kotlinType");
        C12238m.checkNotNullParameter(interfaceC11651l, "factory");
        C12238m.checkNotNullParameter(c11665z, "mode");
        C12238m.checkNotNullParameter(interfaceC11663x, "typeMappingConfiguration");
        C12238m.checkNotNullParameter(function3, "writeGenericType");
        AbstractC11913c0 abstractC11913c0PreprocessType = interfaceC11663x.preprocessType(abstractC11913c0);
        if (abstractC11913c0PreprocessType != null) {
            return (T) mapType(abstractC11913c0PreprocessType, interfaceC11651l, c11665z, interfaceC11663x, c11648i, function3);
        }
        if (C11287g.isSuspendFunctionType(abstractC11913c0)) {
            return (T) mapType(C11292l.transformSuspendFunctionToRuntimeFunctionType(abstractC11913c0, interfaceC11663x.releaseCoroutines()), interfaceC11651l, c11665z, interfaceC11663x, c11648i, function3);
        }
        C11956p c11956p = C11956p.f24827a;
        Object objMapBuiltInType = C11634a0.mapBuiltInType(c11956p, abstractC11913c0, interfaceC11651l, c11665z);
        if (objMapBuiltInType != null) {
            ?? r11 = (Object) C11634a0.boxTypeIfNeeded(interfaceC11651l, objMapBuiltInType, c11665z.getNeedPrimitiveBoxing());
            function3.invoke(abstractC11913c0, r11, c11665z);
            return r11;
        }
        InterfaceC12008u0 constructor = abstractC11913c0.getConstructor();
        if (constructor instanceof C11907a0) {
            C11907a0 c11907a0 = (C11907a0) constructor;
            AbstractC11913c0 alternativeType = c11907a0.getAlternativeType();
            if (alternativeType == null) {
                alternativeType = interfaceC11663x.commonSupertype(c11907a0.getSupertypes());
            }
            return (T) mapType(C11992a.replaceArgumentsWithStarProjections(alternativeType), interfaceC11651l, c11665z, interfaceC11663x, c11648i, function3);
        }
        InterfaceC11352h declarationDescriptor = constructor.getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            throw new UnsupportedOperationException(C12238m.stringPlus("no descriptor for type constructor of ", abstractC11913c0));
        }
        if (C12005t.isError(declarationDescriptor)) {
            T t2 = (T) interfaceC11651l.createObjectType2("error/NonExistentClass");
            interfaceC11663x.processErrorType(abstractC11913c0, (InterfaceC11330e) declarationDescriptor);
            if (c11648i == null) {
                return t2;
            }
            throw null;
        }
        boolean z2 = declarationDescriptor instanceof InterfaceC11330e;
        if (z2 && AbstractC11288h.isArray(abstractC11913c0)) {
            if (abstractC11913c0.getArguments().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            InterfaceC12012w0 interfaceC12012w0 = abstractC11913c0.getArguments().get(0);
            AbstractC11913c0 type = interfaceC12012w0.getType();
            C12238m.checkNotNullExpressionValue(type, "memberProjection.type");
            if (interfaceC12012w0.getProjectionKind() == EnumC11935j1.IN_VARIANCE) {
                objMapType = interfaceC11651l.createObjectType2("java/lang/Object");
                if (c11648i != null) {
                    throw null;
                }
            } else {
                if (c11648i != null) {
                    throw null;
                }
                EnumC11935j1 projectionKind = interfaceC12012w0.getProjectionKind();
                C12238m.checkNotNullExpressionValue(projectionKind, "memberProjection.projectionKind");
                objMapType = mapType(type, interfaceC11651l, c11665z.toGenericArgumentMode(projectionKind, true), interfaceC11663x, c11648i, function3);
                if (c11648i != null) {
                    throw null;
                }
            }
            return (T) interfaceC11651l.createFromString(C12238m.stringPlus("[", interfaceC11651l.toString(objMapType)));
        }
        if (!z2) {
            if (!(declarationDescriptor instanceof InterfaceC11477z0)) {
                if ((declarationDescriptor instanceof InterfaceC11475y0) && c11665z.getMapTypeAliases()) {
                    return (T) mapType(((InterfaceC11475y0) declarationDescriptor).getExpandedType(), interfaceC11651l, c11665z, interfaceC11663x, c11648i, function3);
                }
                throw new UnsupportedOperationException(C12238m.stringPlus("Unknown type ", abstractC11913c0));
            }
            T t3 = (T) mapType(C11992a.getRepresentativeUpperBound((InterfaceC11477z0) declarationDescriptor), interfaceC11651l, c11665z, interfaceC11663x, null, C12036d.getDO_NOTHING_3());
            if (c11648i == null) {
                return t3;
            }
            C12238m.checkNotNullExpressionValue(declarationDescriptor.getName(), "descriptor.getName()");
            throw null;
        }
        if (C11789g.isInlineClass(declarationDescriptor) && !c11665z.getNeedInlineClassWrapping() && (abstractC11913c1 = (AbstractC11913c0) C12007u.computeExpandedTypeForInlineClass(c11956p, abstractC11913c0)) != null) {
            return (T) mapType(abstractC11913c1, interfaceC11651l, c11665z.wrapInlineClassesMode(), interfaceC11663x, c11648i, function3);
        }
        if (c11665z.isForAnnotationParameter() && AbstractC11288h.isKClass((InterfaceC11330e) declarationDescriptor)) {
            t = (Object) interfaceC11651l.getJavaLangClassType();
        } else {
            InterfaceC11330e interfaceC11330e = (InterfaceC11330e) declarationDescriptor;
            InterfaceC11330e original = interfaceC11330e.getOriginal();
            C12238m.checkNotNullExpressionValue(original, "descriptor.original");
            T predefinedTypeForClass = interfaceC11663x.getPredefinedTypeForClass(original);
            if (predefinedTypeForClass == null) {
                if (interfaceC11330e.getKind() == EnumC11333f.ENUM_ENTRY) {
                    interfaceC11330e = (InterfaceC11330e) interfaceC11330e.getContainingDeclaration();
                }
                InterfaceC11330e original2 = interfaceC11330e.getOriginal();
                C12238m.checkNotNullExpressionValue(original2, "enumClassIfEnumEntry.original");
                t = (Object) interfaceC11651l.createObjectType2(computeInternalName(original2, interfaceC11663x));
            } else {
                t = (Object) predefinedTypeForClass;
            }
        }
        function3.invoke(abstractC11913c0, t, c11665z);
        return t;
    }

    public static /* synthetic */ Object mapType$default(AbstractC11913c0 abstractC11913c0, InterfaceC11651l interfaceC11651l, C11665z c11665z, InterfaceC11663x interfaceC11663x, C11648i c11648i, Function3 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = C12036d.getDO_NOTHING_3();
        }
        return mapType(abstractC11913c0, interfaceC11651l, c11665z, interfaceC11663x, c11648i, function3);
    }
}
