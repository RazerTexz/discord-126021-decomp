package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Visibility2;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.e0.p.d.m0.p.numbers;
import d0.e0.p.d.m0.p.numbers2;
import d0.g0.StringNumberConversions;
import d0.g0.StringNumberConversionsJVM2;
import d0.g0._Strings;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.f0, reason: use source file name */
/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class utils2 {
    public static final utils6 lexicalCastFrom(KotlinType kotlinType, String str) {
        Object doubleOrNull;
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics3.checkNotNullParameter(str, "value");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor.getKind() == ClassKind.ENUM_CLASS) {
                MemberScope3 unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
                Name nameIdentifier = Name.identifier(str);
                Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(value)");
                ClassifierDescriptor contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(nameIdentifier, LookupLocation3.FROM_BACKEND);
                if (!(contributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                ClassDescriptor classDescriptor2 = (ClassDescriptor) contributedClassifier;
                if (classDescriptor2.getKind() == ClassKind.ENUM_ENTRY) {
                    return new utils5(classDescriptor2);
                }
                return null;
            }
        }
        KotlinType kotlinTypeMakeNotNullable = TypeUtils2.makeNotNullable(kotlinType);
        numbers numbersVarExtractRadix = numbers2.extractRadix(str);
        String strComponent1 = numbersVarExtractRadix.component1();
        int iComponent2 = numbersVarExtractRadix.component2();
        try {
            if (KotlinBuiltIns.isBoolean(kotlinTypeMakeNotNullable)) {
                doubleOrNull = Boolean.valueOf(Boolean.parseBoolean(str));
            } else if (KotlinBuiltIns.isChar(kotlinTypeMakeNotNullable)) {
                doubleOrNull = _Strings.singleOrNull(str);
            } else if (KotlinBuiltIns.isByte(kotlinTypeMakeNotNullable)) {
                doubleOrNull = StringNumberConversions.toByteOrNull(strComponent1, iComponent2);
            } else if (KotlinBuiltIns.isShort(kotlinTypeMakeNotNullable)) {
                doubleOrNull = StringNumberConversions.toShortOrNull(strComponent1, iComponent2);
            } else if (KotlinBuiltIns.isInt(kotlinTypeMakeNotNullable)) {
                doubleOrNull = StringNumberConversions.toIntOrNull(strComponent1, iComponent2);
            } else if (KotlinBuiltIns.isLong(kotlinTypeMakeNotNullable)) {
                doubleOrNull = StringNumberConversions.toLongOrNull(strComponent1, iComponent2);
            } else if (KotlinBuiltIns.isFloat(kotlinTypeMakeNotNullable)) {
                doubleOrNull = StringNumberConversionsJVM2.toFloatOrNull(str);
            } else if (KotlinBuiltIns.isDouble(kotlinTypeMakeNotNullable)) {
                doubleOrNull = StringNumberConversionsJVM2.toDoubleOrNull(str);
            } else {
                doubleOrNull = KotlinBuiltIns.isString(kotlinTypeMakeNotNullable) ? null : null;
            }
        } catch (IllegalArgumentException unused) {
        }
        if (doubleOrNull != null) {
            return new utils3(doubleOrNull);
        }
        return null;
    }

    public static final DescriptorVisibility2 toDescriptorVisibility(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "<this>");
        DescriptorVisibility2 descriptorVisibility = JavaDescriptorVisibilities.toDescriptorVisibility(visibility2);
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(this)");
        return descriptorVisibility;
    }
}
