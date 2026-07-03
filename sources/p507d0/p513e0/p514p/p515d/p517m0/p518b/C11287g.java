package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p.EnumC11298c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.C11347j;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11831w;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12033a;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.g */
/* JADX INFO: compiled from: functionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11287g {
    public static final AbstractC11934j0 createFunctionType(AbstractC11288h abstractC11288h, InterfaceC11344g interfaceC11344g, AbstractC11913c0 abstractC11913c0, List<? extends AbstractC11913c0> list, List<C11716e> list2, AbstractC11913c0 abstractC11913c1, boolean z2) {
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(list, "parameterTypes");
        C12238m.checkNotNullParameter(abstractC11913c1, "returnType");
        List<InterfaceC12012w0> functionTypeArgumentProjections = getFunctionTypeArgumentProjections(abstractC11913c0, list, list2, abstractC11913c1, abstractC11288h);
        int size = list.size();
        if (abstractC11913c0 != null) {
            size++;
        }
        InterfaceC11330e functionDescriptor = getFunctionDescriptor(abstractC11288h, size, z2);
        if (abstractC11913c0 != null) {
            interfaceC11344g = withExtensionFunctionAnnotation(interfaceC11344g, abstractC11288h);
        }
        C11916d0 c11916d0 = C11916d0.f24748a;
        return C11916d0.simpleNotNullType(interfaceC11344g, functionDescriptor, functionTypeArgumentProjections);
    }

    public static final C11716e extractParameterNameFromFunctionTypeArgument(AbstractC11913c0 abstractC11913c0) {
        String value;
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11340c interfaceC11340cFindAnnotation = abstractC11913c0.getAnnotations().findAnnotation(C11291k.a.f22570y);
        if (interfaceC11340cFindAnnotation == null) {
            return null;
        }
        Object objSingleOrNull = C12163u.singleOrNull(interfaceC11340cFindAnnotation.getAllValueArguments().values());
        C11831w c11831w = objSingleOrNull instanceof C11831w ? (C11831w) objSingleOrNull : null;
        if (c11831w == null || (value = c11831w.getValue()) == null || !C11716e.isValidIdentifier(value)) {
            value = null;
        }
        if (value == null) {
            return null;
        }
        return C11716e.identifier(value);
    }

    public static final InterfaceC11330e getFunctionDescriptor(AbstractC11288h abstractC11288h, int i, boolean z2) {
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
        InterfaceC11330e suspendFunction = z2 ? abstractC11288h.getSuspendFunction(i) : abstractC11288h.getFunction(i);
        C12238m.checkNotNullExpressionValue(suspendFunction, "if (isSuspendFunction) builtIns.getSuspendFunction(parameterCount) else builtIns.getFunction(parameterCount)");
        return suspendFunction;
    }

    public static final List<InterfaceC12012w0> getFunctionTypeArgumentProjections(AbstractC11913c0 abstractC11913c0, List<? extends AbstractC11913c0> list, List<C11716e> list2, AbstractC11913c0 abstractC11913c1, AbstractC11288h abstractC11288h) {
        C11716e c11716e;
        C12238m.checkNotNullParameter(list, "parameterTypes");
        C12238m.checkNotNullParameter(abstractC11913c1, "returnType");
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
        int i = 0;
        ArrayList arrayList = new ArrayList(list.size() + (abstractC11913c0 != null ? 1 : 0) + 1);
        C12033a.addIfNotNull(arrayList, abstractC11913c0 == null ? null : C11992a.asTypeProjection(abstractC11913c0));
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            AbstractC11913c0 abstractC11913c0ReplaceAnnotations = (AbstractC11913c0) obj;
            if (list2 == null || (c11716e = list2.get(i)) == null || c11716e.isSpecial()) {
                c11716e = null;
            }
            if (c11716e != null) {
                C11713b c11713b = C11291k.a.f22570y;
                C11716e c11716eIdentifier = C11716e.identifier(ModelAuditLogEntry.CHANGE_KEY_NAME);
                String strAsString = c11716e.asString();
                C12238m.checkNotNullExpressionValue(strAsString, "name.asString()");
                abstractC11913c0ReplaceAnnotations = C11992a.replaceAnnotations(abstractC11913c0ReplaceAnnotations, InterfaceC11344g.f22735f.create(C12163u.plus(abstractC11913c0ReplaceAnnotations.getAnnotations(), new C11347j(abstractC11288h, c11713b, C12134g0.mapOf(C12116o.m10073to(c11716eIdentifier, new C11831w(strAsString)))))));
            }
            arrayList.add(C11992a.asTypeProjection(abstractC11913c0ReplaceAnnotations));
            i = i2;
        }
        arrayList.add(C11992a.asTypeProjection(abstractC11913c1));
        return arrayList;
    }

    public static final EnumC11298c getFunctionalClassKind(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        if (!(interfaceC11450m instanceof InterfaceC11330e) || !AbstractC11288h.isUnderKotlinPackage(interfaceC11450m)) {
            return null;
        }
        C11714c fqNameUnsafe = C11836a.getFqNameUnsafe(interfaceC11450m);
        if (!fqNameUnsafe.isSafe() || fqNameUnsafe.isRoot()) {
            return null;
        }
        EnumC11298c.a aVar = EnumC11298c.f22601j;
        String strAsString = fqNameUnsafe.shortName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "shortName().asString()");
        C11713b c11713bParent = fqNameUnsafe.toSafe().parent();
        C12238m.checkNotNullExpressionValue(c11713bParent, "toSafe().parent()");
        return aVar.getFunctionalClassKind(strAsString, c11713bParent);
    }

    public static final AbstractC11913c0 getReceiverTypeFromFunctionType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        isBuiltinFunctionalType(abstractC11913c0);
        if (abstractC11913c0.getAnnotations().findAnnotation(C11291k.a.f22569x) != null) {
            return ((InterfaceC12012w0) C12163u.first((List) abstractC11913c0.getArguments())).getType();
        }
        return null;
    }

    public static final AbstractC11913c0 getReturnTypeFromFunctionType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        isBuiltinFunctionalType(abstractC11913c0);
        AbstractC11913c0 type = ((InterfaceC12012w0) C12163u.last((List) abstractC11913c0.getArguments())).getType();
        C12238m.checkNotNullExpressionValue(type, "arguments.last().type");
        return type;
    }

    public static final List<InterfaceC12012w0> getValueParameterTypesFromFunctionType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        isBuiltinFunctionalType(abstractC11913c0);
        List<InterfaceC12012w0> arguments = abstractC11913c0.getArguments();
        return arguments.subList(isBuiltinExtensionFunctionalType(abstractC11913c0) ? 1 : 0, arguments.size() - 1);
    }

    public static final boolean isBuiltinExtensionFunctionalType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        if (isBuiltinFunctionalType(abstractC11913c0)) {
            return abstractC11913c0.getAnnotations().findAnnotation(C11291k.a.f22569x) != null;
        }
        return false;
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        EnumC11298c functionalClassKind = getFunctionalClassKind(interfaceC11450m);
        return functionalClassKind == EnumC11298c.f22602k || functionalClassKind == EnumC11298c.f22603l;
    }

    public static final boolean isBuiltinFunctionalType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        return C12238m.areEqual(declarationDescriptor == null ? null : Boolean.valueOf(isBuiltinFunctionalClassDescriptor(declarationDescriptor)), Boolean.TRUE);
    }

    public static final boolean isFunctionType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : getFunctionalClassKind(declarationDescriptor)) == EnumC11298c.f22602k;
    }

    public static final boolean isSuspendFunctionType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        return (declarationDescriptor == null ? null : getFunctionalClassKind(declarationDescriptor)) == EnumC11298c.f22603l;
    }

    public static final InterfaceC11344g withExtensionFunctionAnnotation(InterfaceC11344g interfaceC11344g, AbstractC11288h abstractC11288h) {
        C12238m.checkNotNullParameter(interfaceC11344g, "<this>");
        C12238m.checkNotNullParameter(abstractC11288h, "builtIns");
        C11713b c11713b = C11291k.a.f22569x;
        return interfaceC11344g.hasAnnotation(c11713b) ? interfaceC11344g : InterfaceC11344g.f22735f.create(C12163u.plus(interfaceC11344g, new C11347j(abstractC11288h, c11713b, C12136h0.emptyMap())));
    }
}
