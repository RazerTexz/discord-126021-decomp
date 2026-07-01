package d0.e0.p.d;

import d0.e0.p.d.RuntimeTypeMapper;
import d0.e0.p.d.RuntimeTypeMapper2;
import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.b.q.CloneableClassScope;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMap;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertyGetterDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaClass;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaConstructor;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaField;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaMethod;
import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.e0.p.d.m0.e.a.JvmAbi;
import d0.e0.p.d.m0.e.a.h0.JavaClassConstructorDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaMethodDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaPropertyDescriptor;
import d0.e0.p.d.m0.e.a.j0.JavaSourceElementFactory;
import d0.e0.p.d.m0.e.a.specialBuiltinMembers;
import d0.e0.p.d.m0.e.b.methodSignatureMapping3;
import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.f.a0.b.JvmMemberSignature;
import d0.e0.p.d.m0.f.a0.b.JvmProtoBufUtil;
import d0.e0.p.d.m0.f.z.ProtoBufUtil;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.inlineClassesUtils;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor4;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: d0.e0.p.d.f0, reason: use source file name */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeTypeMapper3 {
    public static final ClassId a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RuntimeTypeMapper3 f3198b = new RuntimeTypeMapper3();

    static {
        ClassId classId = ClassId.topLevel(new FqName("java.lang.Void"));
        Intrinsics3.checkNotNullExpressionValue(classId, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        a = classId;
    }

    public final PrimitiveType a(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return null;
        }
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(cls.getSimpleName());
        Intrinsics3.checkNotNullExpressionValue(jvmPrimitiveType, "JvmPrimitiveType.get(simpleName)");
        return jvmPrimitiveType.getPrimitiveType();
    }

    public final RuntimeTypeMapper.e b(FunctionDescriptor functionDescriptor) {
        String jvmMethodNameIfSpecial = specialBuiltinMembers.getJvmMethodNameIfSpecial(functionDescriptor);
        if (jvmMethodNameIfSpecial == null) {
            if (functionDescriptor instanceof PropertyGetterDescriptor) {
                String strAsString = DescriptorUtils2.getPropertyIfAccessor(functionDescriptor).getName().asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString, "descriptor.propertyIfAccessor.name.asString()");
                jvmMethodNameIfSpecial = JvmAbi.getterName(strAsString);
            } else if (functionDescriptor instanceof PropertySetterDescriptor) {
                String strAsString2 = DescriptorUtils2.getPropertyIfAccessor(functionDescriptor).getName().asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString2, "descriptor.propertyIfAccessor.name.asString()");
                jvmMethodNameIfSpecial = JvmAbi.setterName(strAsString2);
            } else {
                jvmMethodNameIfSpecial = functionDescriptor.getName().asString();
                Intrinsics3.checkNotNullExpressionValue(jvmMethodNameIfSpecial, "descriptor.name.asString()");
            }
        }
        return new RuntimeTypeMapper.e(new JvmMemberSignature.b(jvmMethodNameIfSpecial, methodSignatureMapping3.computeJvmDescriptor$default(functionDescriptor, false, false, 1, null)));
    }

    public final ClassId mapJvmClassToKotlinClassId(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            Intrinsics3.checkNotNullExpressionValue(componentType, "klass.componentType");
            PrimitiveType primitiveTypeA = a(componentType);
            if (primitiveTypeA != null) {
                return new ClassId(StandardNames.l, primitiveTypeA.getArrayTypeName());
            }
            ClassId classId = ClassId.topLevel(StandardNames.a.h.toSafe());
            Intrinsics3.checkNotNullExpressionValue(classId, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
            return classId;
        }
        if (Intrinsics3.areEqual(cls, Void.TYPE)) {
            return a;
        }
        PrimitiveType primitiveTypeA2 = a(cls);
        if (primitiveTypeA2 != null) {
            return new ClassId(StandardNames.l, primitiveTypeA2.getTypeName());
        }
        ClassId classId2 = reflectClassUtil.getClassId(cls);
        if (!classId2.isLocal()) {
            JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.a;
            FqName fqNameAsSingleFqName = classId2.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "classId.asSingleFqName()");
            ClassId classIdMapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(fqNameAsSingleFqName);
            if (classIdMapJavaToKotlin != null) {
                return classIdMapJavaToKotlin;
            }
        }
        return classId2;
    }

    public final RuntimeTypeMapper2 mapPropertySignature(PropertyDescriptor propertyDescriptor) {
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "possiblyOverriddenProperty");
        CallableMemberDescriptor callableMemberDescriptorUnwrapFakeOverride = DescriptorUtils.unwrapFakeOverride(propertyDescriptor);
        Intrinsics3.checkNotNullExpressionValue(callableMemberDescriptorUnwrapFakeOverride, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        PropertyDescriptor original = ((PropertyDescriptor) callableMemberDescriptorUnwrapFakeOverride).getOriginal();
        Intrinsics3.checkNotNullExpressionValue(original, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        if (original instanceof DeserializedMemberDescriptor4) {
            DeserializedMemberDescriptor4 deserializedMemberDescriptor4 = (DeserializedMemberDescriptor4) original;
            d0.e0.p.d.m0.f.n proto = deserializedMemberDescriptor4.getProto();
            GeneratedMessageLite.f<d0.e0.p.d.m0.f.n, JvmProtoBuf.d> fVar = JvmProtoBuf.d;
            Intrinsics3.checkNotNullExpressionValue(fVar, "JvmProtoBuf.propertySignature");
            JvmProtoBuf.d dVar = (JvmProtoBuf.d) ProtoBufUtil.getExtensionOrNull(proto, fVar);
            if (dVar != null) {
                return new RuntimeTypeMapper2.c(original, proto, dVar, deserializedMemberDescriptor4.getNameResolver(), deserializedMemberDescriptor4.getTypeTable());
            }
        } else if (original instanceof JavaPropertyDescriptor) {
            SourceElement source = ((JavaPropertyDescriptor) original).getSource();
            if (!(source instanceof JavaSourceElementFactory)) {
                source = null;
            }
            JavaSourceElementFactory javaSourceElementFactory = (JavaSourceElementFactory) source;
            d0.e0.p.d.m0.e.a.k0.l javaElement = javaSourceElementFactory != null ? javaSourceElementFactory.getJavaElement() : null;
            if (javaElement instanceof ReflectJavaField) {
                return new RuntimeTypeMapper2.a(((ReflectJavaField) javaElement).getMember());
            }
            if (!(javaElement instanceof ReflectJavaMethod)) {
                throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + original + " (source = " + javaElement + ')');
            }
            Method member = ((ReflectJavaMethod) javaElement).getMember();
            PropertySetterDescriptor setter = original.getSetter();
            SourceElement source2 = setter != null ? setter.getSource() : null;
            if (!(source2 instanceof JavaSourceElementFactory)) {
                source2 = null;
            }
            JavaSourceElementFactory javaSourceElementFactory2 = (JavaSourceElementFactory) source2;
            d0.e0.p.d.m0.e.a.k0.l javaElement2 = javaSourceElementFactory2 != null ? javaSourceElementFactory2.getJavaElement() : null;
            if (!(javaElement2 instanceof ReflectJavaMethod)) {
                javaElement2 = null;
            }
            ReflectJavaMethod reflectJavaMethod = (ReflectJavaMethod) javaElement2;
            return new RuntimeTypeMapper2.b(member, reflectJavaMethod != null ? reflectJavaMethod.getMember() : null);
        }
        PropertyGetterDescriptor getter = original.getGetter();
        Intrinsics3.checkNotNull(getter);
        RuntimeTypeMapper.e eVarB = b(getter);
        PropertySetterDescriptor setter2 = original.getSetter();
        return new RuntimeTypeMapper2.d(eVarB, setter2 != null ? b(setter2) : null);
    }

    public final RuntimeTypeMapper mapSignature(FunctionDescriptor functionDescriptor) {
        Method member;
        JvmMemberSignature.b jvmConstructorSignature;
        JvmMemberSignature.b jvmMethodSignature;
        Intrinsics3.checkNotNullParameter(functionDescriptor, "possiblySubstitutedFunction");
        CallableMemberDescriptor callableMemberDescriptorUnwrapFakeOverride = DescriptorUtils.unwrapFakeOverride(functionDescriptor);
        Intrinsics3.checkNotNullExpressionValue(callableMemberDescriptorUnwrapFakeOverride, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        FunctionDescriptor original = ((FunctionDescriptor) callableMemberDescriptorUnwrapFakeOverride).getOriginal();
        Intrinsics3.checkNotNullExpressionValue(original, "DescriptorUtils.unwrapFa…titutedFunction).original");
        if (original instanceof DeserializedMemberDescriptor) {
            DeserializedMemberDescriptor deserializedMemberDescriptor = (DeserializedMemberDescriptor) original;
            MessageLite proto = deserializedMemberDescriptor.getProto();
            if ((proto instanceof d0.e0.p.d.m0.f.i) && (jvmMethodSignature = JvmProtoBufUtil.a.getJvmMethodSignature((d0.e0.p.d.m0.f.i) proto, deserializedMemberDescriptor.getNameResolver(), deserializedMemberDescriptor.getTypeTable())) != null) {
                return new RuntimeTypeMapper.e(jvmMethodSignature);
            }
            if (!(proto instanceof d0.e0.p.d.m0.f.d) || (jvmConstructorSignature = JvmProtoBufUtil.a.getJvmConstructorSignature((d0.e0.p.d.m0.f.d) proto, deserializedMemberDescriptor.getNameResolver(), deserializedMemberDescriptor.getTypeTable())) == null) {
                return b(original);
            }
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "possiblySubstitutedFunction.containingDeclaration");
            return inlineClassesUtils.isInlineClass(containingDeclaration) ? new RuntimeTypeMapper.e(jvmConstructorSignature) : new RuntimeTypeMapper.d(jvmConstructorSignature);
        }
        if (original instanceof JavaMethodDescriptor) {
            SourceElement source = ((JavaMethodDescriptor) original).getSource();
            if (!(source instanceof JavaSourceElementFactory)) {
                source = null;
            }
            JavaSourceElementFactory javaSourceElementFactory = (JavaSourceElementFactory) source;
            d0.e0.p.d.m0.e.a.k0.l javaElement = javaSourceElementFactory != null ? javaSourceElementFactory.getJavaElement() : null;
            ReflectJavaMethod reflectJavaMethod = (ReflectJavaMethod) (javaElement instanceof ReflectJavaMethod ? javaElement : null);
            if (reflectJavaMethod != null && (member = reflectJavaMethod.getMember()) != null) {
                return new RuntimeTypeMapper.c(member);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + original);
        }
        if (!(original instanceof JavaClassConstructorDescriptor)) {
            boolean z2 = true;
            if (!DescriptorFactory.isEnumValueOfMethod(original) && !DescriptorFactory.isEnumValuesMethod(original) && (!Intrinsics3.areEqual(original.getName(), CloneableClassScope.e.getCLONE_NAME()) || !original.getValueParameters().isEmpty())) {
                z2 = false;
            }
            if (z2) {
                return b(original);
            }
            throw new KotlinReflectionInternalError("Unknown origin of " + original + " (" + original.getClass() + ')');
        }
        SourceElement source2 = ((JavaClassConstructorDescriptor) original).getSource();
        if (!(source2 instanceof JavaSourceElementFactory)) {
            source2 = null;
        }
        JavaSourceElementFactory javaSourceElementFactory2 = (JavaSourceElementFactory) source2;
        d0.e0.p.d.m0.e.a.k0.l javaElement2 = javaSourceElementFactory2 != null ? javaSourceElementFactory2.getJavaElement() : null;
        if (javaElement2 instanceof ReflectJavaConstructor) {
            return new RuntimeTypeMapper.b(((ReflectJavaConstructor) javaElement2).getMember());
        }
        if (javaElement2 instanceof ReflectJavaClass) {
            ReflectJavaClass reflectJavaClass = (ReflectJavaClass) javaElement2;
            if (reflectJavaClass.isAnnotationType()) {
                return new RuntimeTypeMapper.a(reflectJavaClass.getElement());
            }
        }
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + original + " (" + javaElement2 + ')');
    }
}
