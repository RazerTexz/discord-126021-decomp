package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.PropertyAccessorDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaClassDescriptor;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.l1.TypeCheckingProcedure;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d0, reason: use source file name */
/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class specialBuiltinMembers {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d0$a */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class a extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(invoke2(callableMemberDescriptor));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
            return ClassicBuiltinSpecialProperties.a.hasBuiltinSpecialPropertyFqName(DescriptorUtils2.getPropertyIfAccessor(callableMemberDescriptor));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d0$b */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class b extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(invoke2(callableMemberDescriptor));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
            return specialBuiltinMembers2.m.isBuiltinFunctionWithDifferentNameInJvm((SimpleFunctionDescriptor) callableMemberDescriptor);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d0$c */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class c extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(invoke2(callableMemberDescriptor));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
            if (KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
                specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.m;
                if (specialBuiltinMembers3.getSpecialSignatureInfo(callableMemberDescriptor) != null) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final boolean doesOverrideBuiltinWithDifferentJvmName(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        return getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor) != null;
    }

    public static final String getJvmMethodNameIfSpecial(CallableMemberDescriptor callableMemberDescriptor) {
        Name jvmName;
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor overriddenBuiltinWithDifferentJvmName = KotlinBuiltIns.isBuiltIn(callableMemberDescriptor) ? getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor) : null;
        CallableMemberDescriptor propertyIfAccessor = overriddenBuiltinWithDifferentJvmName == null ? null : DescriptorUtils2.getPropertyIfAccessor(overriddenBuiltinWithDifferentJvmName);
        if (propertyIfAccessor == null) {
            return null;
        }
        if (propertyIfAccessor instanceof PropertyDescriptor) {
            return ClassicBuiltinSpecialProperties.a.getBuiltinSpecialPropertyGetterName(propertyIfAccessor);
        }
        if (!(propertyIfAccessor instanceof SimpleFunctionDescriptor) || (jvmName = specialBuiltinMembers2.m.getJvmName((SimpleFunctionDescriptor) propertyIfAccessor)) == null) {
            return null;
        }
        return jvmName.asString();
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(T t) {
        Intrinsics3.checkNotNullParameter(t, "<this>");
        if (!SpecialGenericSignatures.a.getORIGINAL_SHORT_NAMES().contains(t.getName()) && !BuiltinSpecialProperties.a.getSPECIAL_SHORT_NAMES().contains(DescriptorUtils2.getPropertyIfAccessor(t).getName())) {
            return null;
        }
        if (t instanceof PropertyDescriptor ? true : t instanceof PropertyAccessorDescriptor) {
            return (T) DescriptorUtils2.firstOverridden$default(t, false, a.j, 1, null);
        }
        if (t instanceof SimpleFunctionDescriptor) {
            return (T) DescriptorUtils2.firstOverridden$default(t, false, b.j, 1, null);
        }
        return null;
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(T t) {
        Intrinsics3.checkNotNullParameter(t, "<this>");
        T t2 = (T) getOverriddenBuiltinWithDifferentJvmName(t);
        if (t2 != null) {
            return t2;
        }
        specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.m;
        Name name = t.getName();
        Intrinsics3.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (specialbuiltinmembers3.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (T) DescriptorUtils2.firstOverridden$default(t, false, c.j, 1, null);
        }
        return null;
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(ClassDescriptor classDescriptor, CallableDescriptor callableDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(callableDescriptor, "specialCallableDescriptor");
        KotlinType4 defaultType = ((ClassDescriptor) callableDescriptor.getContainingDeclaration()).getDefaultType();
        Intrinsics3.checkNotNullExpressionValue(defaultType, "specialCallableDescriptor.containingDeclaration as ClassDescriptor).defaultType");
        ClassDescriptor superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(classDescriptor);
        while (true) {
            if (superClassDescriptor == null) {
                return false;
            }
            if (!(superClassDescriptor instanceof JavaClassDescriptor)) {
                if (TypeCheckingProcedure.findCorrespondingSupertype(superClassDescriptor.getDefaultType(), defaultType) != null) {
                    return !KotlinBuiltIns.isBuiltIn(superClassDescriptor);
                }
            }
            superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(superClassDescriptor);
        }
    }

    public static final boolean isFromJava(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        return DescriptorUtils2.getPropertyIfAccessor(callableMemberDescriptor).getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        return isFromJava(callableMemberDescriptor) || KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
    }
}
