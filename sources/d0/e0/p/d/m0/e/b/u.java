package d0.e0.p.d.m0.e.b;

import androidx.exifinterface.media.ExifInterface;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.e.a.d0;
import d0.e0.p.d.m0.n.c0;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static final void a(StringBuilder sb, c0 c0Var) {
        sb.append(mapToJvmType(c0Var));
    }

    public static final String computeJvmDescriptor(d0.e0.p.d.m0.c.x xVar, boolean z2, boolean z3) {
        String strAsString;
        d0.z.d.m.checkNotNullParameter(xVar, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z3) {
            if (xVar instanceof d0.e0.p.d.m0.c.l) {
                strAsString = "<init>";
            } else {
                strAsString = xVar.getName().asString();
                d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
            }
            sb.append(strAsString);
        }
        sb.append("(");
        q0 extensionReceiverParameter = xVar.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            c0 type = extensionReceiverParameter.getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "it.type");
            a(sb, type);
        }
        Iterator<c1> it = xVar.getValueParameters().iterator();
        while (it.hasNext()) {
            c0 type2 = it.next().getType();
            d0.z.d.m.checkNotNullExpressionValue(type2, "parameter.type");
            a(sb, type2);
        }
        sb.append(")");
        if (z2) {
            if (d.hasVoidReturnType(xVar)) {
                sb.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            } else {
                c0 returnType = xVar.getReturnType();
                d0.z.d.m.checkNotNull(returnType);
                a(sb, returnType);
            }
        }
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String computeJvmDescriptor$default(d0.e0.p.d.m0.c.x xVar, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        return computeJvmDescriptor(xVar, z2, z3);
    }

    public static final String computeJvmSignature(d0.e0.p.d.m0.c.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "<this>");
        w wVar = w.a;
        if (d0.e0.p.d.m0.k.e.isLocal(aVar)) {
            return null;
        }
        d0.e0.p.d.m0.c.m containingDeclaration = aVar.getContainingDeclaration();
        d0.e0.p.d.m0.c.e eVar = containingDeclaration instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) containingDeclaration : null;
        if (eVar == null || eVar.getName().isSpecial()) {
            return null;
        }
        d0.e0.p.d.m0.c.a original = aVar.getOriginal();
        t0 t0Var = original instanceof t0 ? (t0) original : null;
        if (t0Var == null) {
            return null;
        }
        return t.signature(wVar, eVar, computeJvmDescriptor$default(t0Var, false, false, 3, null));
    }

    public static final boolean forceSingleValueParameterBoxing(d0.e0.p.d.m0.c.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "f");
        if (!(aVar instanceof d0.e0.p.d.m0.c.x)) {
            return false;
        }
        d0.e0.p.d.m0.c.x xVar = (d0.e0.p.d.m0.c.x) aVar;
        if (!d0.z.d.m.areEqual(xVar.getName().asString(), "remove") || xVar.getValueParameters().size() != 1 || d0.isFromJavaOrBuiltins((d0.e0.p.d.m0.c.b) aVar)) {
            return false;
        }
        List<c1> valueParameters = xVar.getOriginal().getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "f.original.valueParameters");
        c0 type = ((c1) d0.t.u.single((List) valueParameters)).getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "f.original.valueParameters.single().type");
        k kVarMapToJvmType = mapToJvmType(type);
        k$d k_d = kVarMapToJvmType instanceof k$d ? (k$d) kVarMapToJvmType : null;
        if ((k_d != null ? k_d.getJvmPrimitiveType() : null) != d0.e0.p.d.m0.k.y.d.INT) {
            return false;
        }
        d0.e0.p.d.m0.e.a.h hVar = d0.e0.p.d.m0.e.a.h.m;
        d0.e0.p.d.m0.c.x overriddenBuiltinFunctionWithErasedValueParametersInJava = d0.e0.p.d.m0.e.a.h.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(xVar);
        if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null) {
            return false;
        }
        List<c1> valueParameters2 = overriddenBuiltinFunctionWithErasedValueParametersInJava.getOriginal().getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters2, "overridden.original.valueParameters");
        c0 type2 = ((c1) d0.t.u.single((List) valueParameters2)).getType();
        d0.z.d.m.checkNotNullExpressionValue(type2, "overridden.original.valueParameters.single().type");
        k kVarMapToJvmType2 = mapToJvmType(type2);
        d0.e0.p.d.m0.c.m containingDeclaration = overriddenBuiltinFunctionWithErasedValueParametersInJava.getContainingDeclaration();
        d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "overridden.containingDeclaration");
        return d0.z.d.m.areEqual(d0.e0.p.d.m0.k.x.a.getFqNameUnsafe(containingDeclaration), d0.e0.p.d.m0.b.k$a.R.toUnsafe()) && (kVarMapToJvmType2 instanceof k$c) && d0.z.d.m.areEqual(((k$c) kVarMapToJvmType2).getInternalName(), "java/lang/Object");
    }

    public static final String getInternalName(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        d0.e0.p.d.m0.b.q.c cVar = d0.e0.p.d.m0.b.q.c.a;
        d0.e0.p.d.m0.g.c unsafe = d0.e0.p.d.m0.k.x.a.getFqNameSafe(eVar).toUnsafe();
        d0.z.d.m.checkNotNullExpressionValue(unsafe, "fqNameSafe.toUnsafe()");
        d0.e0.p.d.m0.g.a aVarMapKotlinToJava = cVar.mapKotlinToJava(unsafe);
        if (aVarMapKotlinToJava == null) {
            return d.computeInternalName$default(eVar, null, 2, null);
        }
        String internalName = d0.e0.p.d.m0.k.y.c.byClassId(aVarMapKotlinToJava).getInternalName();
        d0.z.d.m.checkNotNullExpressionValue(internalName, "byClassId(it).internalName");
        return internalName;
    }

    public static final k mapToJvmType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        return (k) d.mapType$default(c0Var, m.a, z.c, y.a, null, null, 32, null);
    }
}
