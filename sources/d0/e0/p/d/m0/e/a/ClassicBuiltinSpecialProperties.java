package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k, reason: use source file name */
/* JADX INFO: compiled from: ClassicBuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassicBuiltinSpecialProperties {
    public static final ClassicBuiltinSpecialProperties a = new ClassicBuiltinSpecialProperties();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.k$a */
    /* JADX INFO: compiled from: ClassicBuiltinSpecialProperties.kt */
    public static final class a extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
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
            return ClassicBuiltinSpecialProperties.this.hasBuiltinSpecialPropertyFqName(callableMemberDescriptor);
        }
    }

    public final String getBuiltinSpecialPropertyGetterName(CallableMemberDescriptor callableMemberDescriptor) {
        Name name;
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
        CallableMemberDescriptor callableMemberDescriptorFirstOverridden$default = DescriptorUtils2.firstOverridden$default(DescriptorUtils2.getPropertyIfAccessor(callableMemberDescriptor), false, new a(), 1, null);
        if (callableMemberDescriptorFirstOverridden$default == null || (name = BuiltinSpecialProperties.a.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(DescriptorUtils2.getFqNameSafe(callableMemberDescriptorFirstOverridden$default))) == null) {
            return null;
        }
        return name.asString();
    }

    public final boolean hasBuiltinSpecialPropertyFqName(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        BuiltinSpecialProperties builtinSpecialProperties = BuiltinSpecialProperties.a;
        if (!builtinSpecialProperties.getSPECIAL_SHORT_NAMES().contains(callableMemberDescriptor.getName())) {
            return false;
        }
        if (!_Collections.contains(builtinSpecialProperties.getSPECIAL_FQ_NAMES(), DescriptorUtils2.fqNameOrNull(callableMemberDescriptor)) || !callableMemberDescriptor.getValueParameters().isEmpty()) {
            if (!KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
                return false;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            if (overriddenDescriptors.isEmpty()) {
                return false;
            }
            for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
                Intrinsics3.checkNotNullExpressionValue(callableMemberDescriptor2, "it");
                if (hasBuiltinSpecialPropertyFqName(callableMemberDescriptor2)) {
                }
            }
            return false;
        }
        return true;
    }
}
