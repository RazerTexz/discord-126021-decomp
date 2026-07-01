package d0.e0.p.d.l0;

import b.d.b.a.outline;
import d0.e0.p.d.KotlinReflectionInternalError;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.VariableDescriptor;
import d0.e0.p.d.m0.k.inlineClassesUtils;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.util2;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.l0.h, reason: use source file name */
/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InlineClassAwareCaller2 {
    public static final KotlinType a(CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof ConstructorDescriptor) {
            return dispatchReceiverParameter.getType();
        }
        DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            containingDeclaration = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        if (classDescriptor != null) {
            return classDescriptor.getDefaultType();
        }
        return null;
    }

    public static final Object coerceToExpectedReceiverType(Object obj, CallableMemberDescriptor callableMemberDescriptor) {
        KotlinType kotlinTypeA;
        Class<?> inlineClass;
        Method unboxMethod;
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        return (((callableMemberDescriptor instanceof PropertyDescriptor) && inlineClassesUtils.isUnderlyingPropertyOfInlineClass((VariableDescriptor) callableMemberDescriptor)) || (kotlinTypeA = a(callableMemberDescriptor)) == null || (inlineClass = toInlineClass(kotlinTypeA)) == null || (unboxMethod = getUnboxMethod(inlineClass, callableMemberDescriptor)) == null) ? obj : unboxMethod.invoke(obj, new Object[0]);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006f  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> Caller2<M> createInlineClassAwareCallerIfNeeded(Caller2<? extends M> caller2, CallableMemberDescriptor callableMemberDescriptor, boolean z2) {
        boolean z3;
        KotlinType returnType;
        Intrinsics3.checkNotNullParameter(caller2, "$this$createInlineClassAwareCallerIfNeeded");
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        boolean z4 = false;
        if (inlineClassesUtils.isGetterOfUnderlyingPropertyOfInlineClass(callableMemberDescriptor)) {
            z4 = true;
        } else {
            List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
                Iterator<T> it = valueParameters.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    }
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) it.next();
                    Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                    KotlinType type = valueParameterDescriptor.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "it.type");
                    if (inlineClassesUtils.isInlineClassType(type)) {
                        z3 = true;
                        break;
                    }
                }
            } else {
                z3 = false;
                break;
            }
            if (z3 || ((returnType = callableMemberDescriptor.getReturnType()) != null && inlineClassesUtils.isInlineClassType(returnType))) {
                z4 = true;
            } else if (!(caller2 instanceof Caller)) {
                KotlinType kotlinTypeA = a(callableMemberDescriptor);
                if (kotlinTypeA != null && inlineClassesUtils.isInlineClassType(kotlinTypeA)) {
                    z4 = true;
                }
            }
        }
        return z4 ? new InlineClassAwareCaller(callableMemberDescriptor, caller2, z2) : caller2;
    }

    public static /* synthetic */ Caller2 createInlineClassAwareCallerIfNeeded$default(Caller2 caller2, CallableMemberDescriptor callableMemberDescriptor, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return createInlineClassAwareCallerIfNeeded(caller2, callableMemberDescriptor, z2);
    }

    public static final Method getBoxMethod(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(cls, "$this$getBoxMethod");
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", getUnboxMethod(cls, callableMemberDescriptor).getReturnType());
            Intrinsics3.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    public static final Method getUnboxMethod(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(cls, "$this$getUnboxMethod");
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            Intrinsics3.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    public static final Class<?> toInlineClass(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "$this$toInlineClass");
        return toInlineClass(kotlinType.getConstructor().getDeclarationDescriptor());
    }

    public static final Class<?> toInlineClass(DeclarationDescriptor declarationDescriptor) {
        if (!(declarationDescriptor instanceof ClassDescriptor) || !inlineClassesUtils.isInlineClass(declarationDescriptor)) {
            return null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        Class<?> javaClass = util2.toJavaClass(classDescriptor);
        if (javaClass != null) {
            return javaClass;
        }
        StringBuilder sbU = outline.U("Class object for the class ");
        sbU.append(classDescriptor.getName());
        sbU.append(" cannot be found (classId=");
        sbU.append(DescriptorUtils2.getClassId((ClassifierDescriptor) declarationDescriptor));
        sbU.append(')');
        throw new KotlinReflectionInternalError(sbU.toString());
    }
}
