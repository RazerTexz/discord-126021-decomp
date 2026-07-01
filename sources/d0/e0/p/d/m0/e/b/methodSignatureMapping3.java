package d0.e0.p.d.m0.e.b;

import androidx.exifinterface.media.ExifInterface;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMap;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.e.a.specialBuiltinMembers;
import d0.e0.p.d.m0.e.a.specialBuiltinMembers3;
import d0.e0.p.d.m0.e.b.methodSignatureMapping;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.k.y.JvmClassName;
import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.u, reason: use source file name */
/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class methodSignatureMapping3 {
    public static final void a(StringBuilder sb, KotlinType kotlinType) {
        sb.append(mapToJvmType(kotlinType));
    }

    public static final String computeJvmDescriptor(FunctionDescriptor functionDescriptor, boolean z2, boolean z3) {
        String strAsString;
        Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z3) {
            if (functionDescriptor instanceof ConstructorDescriptor) {
                strAsString = "<init>";
            } else {
                strAsString = functionDescriptor.getName().asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
            }
            sb.append(strAsString);
        }
        sb.append("(");
        ReceiverParameterDescriptor extensionReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "it.type");
            a(sb, type);
        }
        Iterator<ValueParameterDescriptor> it = functionDescriptor.getValueParameters().iterator();
        while (it.hasNext()) {
            KotlinType type2 = it.next().getType();
            Intrinsics3.checkNotNullExpressionValue(type2, "parameter.type");
            a(sb, type2);
        }
        sb.append(")");
        if (z2) {
            if (descriptorBasedTypeSignatureMapping.hasVoidReturnType(functionDescriptor)) {
                sb.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            } else {
                KotlinType returnType = functionDescriptor.getReturnType();
                Intrinsics3.checkNotNull(returnType);
                a(sb, returnType);
            }
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor functionDescriptor, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        return computeJvmDescriptor(functionDescriptor, z2, z3);
    }

    public static final String computeJvmSignature(CallableDescriptor callableDescriptor) {
        Intrinsics3.checkNotNullParameter(callableDescriptor, "<this>");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
        if (DescriptorUtils.isLocal(callableDescriptor)) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null || classDescriptor.getName().isSpecial()) {
            return null;
        }
        CallableDescriptor original = callableDescriptor.getOriginal();
        SimpleFunctionDescriptor simpleFunctionDescriptor = original instanceof SimpleFunctionDescriptor ? (SimpleFunctionDescriptor) original : null;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        return methodSignatureBuildingUtils.signature(signatureBuildingComponents, classDescriptor, computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null));
    }

    public static final boolean forceSingleValueParameterBoxing(CallableDescriptor callableDescriptor) {
        Intrinsics3.checkNotNullParameter(callableDescriptor, "f");
        if (!(callableDescriptor instanceof FunctionDescriptor)) {
            return false;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
        if (!Intrinsics3.areEqual(functionDescriptor.getName().asString(), "remove") || functionDescriptor.getValueParameters().size() != 1 || specialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor) callableDescriptor)) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getOriginal().getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "f.original.valueParameters");
        KotlinType type = ((ValueParameterDescriptor) _Collections.single((List) valueParameters)).getType();
        Intrinsics3.checkNotNullExpressionValue(type, "f.original.valueParameters.single().type");
        methodSignatureMapping methodsignaturemappingMapToJvmType = mapToJvmType(type);
        methodSignatureMapping.d dVar = methodsignaturemappingMapToJvmType instanceof methodSignatureMapping.d ? (methodSignatureMapping.d) methodsignaturemappingMapToJvmType : null;
        if ((dVar != null ? dVar.getJvmPrimitiveType() : null) != JvmPrimitiveType.INT) {
            return false;
        }
        specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.m;
        FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = specialBuiltinMembers3.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(functionDescriptor);
        if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters2 = overriddenBuiltinFunctionWithErasedValueParametersInJava.getOriginal().getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters2, "overridden.original.valueParameters");
        KotlinType type2 = ((ValueParameterDescriptor) _Collections.single((List) valueParameters2)).getType();
        Intrinsics3.checkNotNullExpressionValue(type2, "overridden.original.valueParameters.single().type");
        methodSignatureMapping methodsignaturemappingMapToJvmType2 = mapToJvmType(type2);
        DeclarationDescriptor containingDeclaration = overriddenBuiltinFunctionWithErasedValueParametersInJava.getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "overridden.containingDeclaration");
        return Intrinsics3.areEqual(DescriptorUtils2.getFqNameUnsafe(containingDeclaration), StandardNames.a.R.toUnsafe()) && (methodsignaturemappingMapToJvmType2 instanceof methodSignatureMapping.c) && Intrinsics3.areEqual(((methodSignatureMapping.c) methodsignaturemappingMapToJvmType2).getInternalName(), "java/lang/Object");
    }

    public static final String getInternalName(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.a;
        FqNameUnsafe unsafe = DescriptorUtils2.getFqNameSafe(classDescriptor).toUnsafe();
        Intrinsics3.checkNotNullExpressionValue(unsafe, "fqNameSafe.toUnsafe()");
        ClassId classIdMapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (classIdMapKotlinToJava == null) {
            return descriptorBasedTypeSignatureMapping.computeInternalName$default(classDescriptor, null, 2, null);
        }
        String internalName = JvmClassName.byClassId(classIdMapKotlinToJava).getInternalName();
        Intrinsics3.checkNotNullExpressionValue(internalName, "byClassId(it).internalName");
        return internalName;
    }

    public static final methodSignatureMapping mapToJvmType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return (methodSignatureMapping) descriptorBasedTypeSignatureMapping.mapType$default(kotlinType, methodSignatureMapping2.a, TypeMappingMode.c, methodSignatureMapping4.a, null, null, 32, null);
    }
}
