package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11303c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11492d0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11509h;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.AbstractC11650k;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.C11839c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.u */
/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11660u {
    /* JADX INFO: renamed from: a */
    public static final void m9549a(StringBuilder sb, AbstractC11913c0 abstractC11913c0) {
        sb.append(mapToJvmType(abstractC11913c0));
    }

    public static final String computeJvmDescriptor(InterfaceC11472x interfaceC11472x, boolean z2, boolean z3) {
        String strAsString;
        C12238m.checkNotNullParameter(interfaceC11472x, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z3) {
            if (interfaceC11472x instanceof InterfaceC11448l) {
                strAsString = "<init>";
            } else {
                strAsString = interfaceC11472x.getName().asString();
                C12238m.checkNotNullExpressionValue(strAsString, "name.asString()");
            }
            sb.append(strAsString);
        }
        sb.append("(");
        InterfaceC11459q0 extensionReceiverParameter = interfaceC11472x.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            AbstractC11913c0 type = extensionReceiverParameter.getType();
            C12238m.checkNotNullExpressionValue(type, "it.type");
            m9549a(sb, type);
        }
        Iterator<InterfaceC11326c1> it = interfaceC11472x.getValueParameters().iterator();
        while (it.hasNext()) {
            AbstractC11913c0 type2 = it.next().getType();
            C12238m.checkNotNullExpressionValue(type2, "parameter.type");
            m9549a(sb, type2);
        }
        sb.append(")");
        if (z2) {
            if (C11643d.hasVoidReturnType(interfaceC11472x)) {
                sb.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            } else {
                AbstractC11913c0 returnType = interfaceC11472x.getReturnType();
                C12238m.checkNotNull(returnType);
                m9549a(sb, returnType);
            }
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String computeJvmDescriptor$default(InterfaceC11472x interfaceC11472x, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        return computeJvmDescriptor(interfaceC11472x, z2, z3);
    }

    public static final String computeJvmSignature(InterfaceC11318a interfaceC11318a) {
        C12238m.checkNotNullParameter(interfaceC11318a, "<this>");
        C11662w c11662w = C11662w.f23636a;
        if (C11787e.isLocal(interfaceC11318a)) {
            return null;
        }
        InterfaceC11450m containingDeclaration = interfaceC11318a.getContainingDeclaration();
        InterfaceC11330e interfaceC11330e = containingDeclaration instanceof InterfaceC11330e ? (InterfaceC11330e) containingDeclaration : null;
        if (interfaceC11330e == null || interfaceC11330e.getName().isSpecial()) {
            return null;
        }
        InterfaceC11318a original = interfaceC11318a.getOriginal();
        InterfaceC11465t0 interfaceC11465t0 = original instanceof InterfaceC11465t0 ? (InterfaceC11465t0) original : null;
        if (interfaceC11465t0 == null) {
            return null;
        }
        return C11659t.signature(c11662w, interfaceC11330e, computeJvmDescriptor$default(interfaceC11465t0, false, false, 3, null));
    }

    public static final boolean forceSingleValueParameterBoxing(InterfaceC11318a interfaceC11318a) {
        C12238m.checkNotNullParameter(interfaceC11318a, "f");
        if (!(interfaceC11318a instanceof InterfaceC11472x)) {
            return false;
        }
        InterfaceC11472x interfaceC11472x = (InterfaceC11472x) interfaceC11318a;
        if (!C12238m.areEqual(interfaceC11472x.getName().asString(), "remove") || interfaceC11472x.getValueParameters().size() != 1 || C11492d0.isFromJavaOrBuiltins((InterfaceC11321b) interfaceC11318a)) {
            return false;
        }
        List<InterfaceC11326c1> valueParameters = interfaceC11472x.getOriginal().getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters, "f.original.valueParameters");
        AbstractC11913c0 type = ((InterfaceC11326c1) C12163u.single((List) valueParameters)).getType();
        C12238m.checkNotNullExpressionValue(type, "f.original.valueParameters.single().type");
        AbstractC11650k abstractC11650kMapToJvmType = mapToJvmType(type);
        AbstractC11650k.d dVar = abstractC11650kMapToJvmType instanceof AbstractC11650k.d ? (AbstractC11650k.d) abstractC11650kMapToJvmType : null;
        if ((dVar != null ? dVar.getJvmPrimitiveType() : null) != EnumC11840d.INT) {
            return false;
        }
        C11509h c11509h = C11509h.f23259m;
        InterfaceC11472x overriddenBuiltinFunctionWithErasedValueParametersInJava = C11509h.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(interfaceC11472x);
        if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null) {
            return false;
        }
        List<InterfaceC11326c1> valueParameters2 = overriddenBuiltinFunctionWithErasedValueParametersInJava.getOriginal().getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters2, "overridden.original.valueParameters");
        AbstractC11913c0 type2 = ((InterfaceC11326c1) C12163u.single((List) valueParameters2)).getType();
        C12238m.checkNotNullExpressionValue(type2, "overridden.original.valueParameters.single().type");
        AbstractC11650k abstractC11650kMapToJvmType2 = mapToJvmType(type2);
        InterfaceC11450m containingDeclaration = overriddenBuiltinFunctionWithErasedValueParametersInJava.getContainingDeclaration();
        C12238m.checkNotNullExpressionValue(containingDeclaration, "overridden.containingDeclaration");
        return C12238m.areEqual(C11836a.getFqNameUnsafe(containingDeclaration), C11291k.a.f22521R.toUnsafe()) && (abstractC11650kMapToJvmType2 instanceof AbstractC11650k.c) && C12238m.areEqual(((AbstractC11650k.c) abstractC11650kMapToJvmType2).getInternalName(), "java/lang/Object");
    }

    public static final String getInternalName(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "<this>");
        C11303c c11303c = C11303c.f22614a;
        C11714c unsafe = C11836a.getFqNameSafe(interfaceC11330e).toUnsafe();
        C12238m.checkNotNullExpressionValue(unsafe, "fqNameSafe.toUnsafe()");
        C11712a c11712aMapKotlinToJava = c11303c.mapKotlinToJava(unsafe);
        if (c11712aMapKotlinToJava == null) {
            return C11643d.computeInternalName$default(interfaceC11330e, null, 2, null);
        }
        String internalName = C11839c.byClassId(c11712aMapKotlinToJava).getInternalName();
        C12238m.checkNotNullExpressionValue(internalName, "byClassId(it).internalName");
        return internalName;
    }

    public static final AbstractC11650k mapToJvmType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return (AbstractC11650k) C11643d.mapType$default(abstractC11913c0, C11652m.f23629a, C11665z.f23640c, C11664y.f23637a, null, null, 32, null);
    }
}
