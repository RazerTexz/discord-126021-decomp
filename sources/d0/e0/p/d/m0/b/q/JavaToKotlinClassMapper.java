package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.d, reason: use source file name */
/* JADX INFO: compiled from: JavaToKotlinClassMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaToKotlinClassMapper {
    public static final JavaToKotlinClassMapper a = new JavaToKotlinClassMapper();

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper javaToKotlinClassMapper, FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return javaToKotlinClassMapper.mapJavaToKotlin(fqName, kotlinBuiltIns, num);
    }

    public final ClassDescriptor convertMutableToReadOnly(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "mutable");
        FqName fqNameMutableToReadOnly = JavaToKotlinClassMap.a.mutableToReadOnly(DescriptorUtils.getFqName(classDescriptor));
        if (fqNameMutableToReadOnly != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtils2.getBuiltIns(classDescriptor).getBuiltInClassByFqName(fqNameMutableToReadOnly);
            Intrinsics3.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a mutable collection");
    }

    public final ClassDescriptor convertReadOnlyToMutable(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "readOnly");
        FqName onlyToMutable = JavaToKotlinClassMap.a.readOnlyToMutable(DescriptorUtils.getFqName(classDescriptor));
        if (onlyToMutable != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtils2.getBuiltIns(classDescriptor).getBuiltInClassByFqName(onlyToMutable);
            Intrinsics3.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a read-only collection");
    }

    public final boolean isMutable(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "mutable");
        return JavaToKotlinClassMap.a.isMutable(DescriptorUtils.getFqName(classDescriptor));
    }

    public final boolean isReadOnly(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "readOnly");
        return JavaToKotlinClassMap.a.isReadOnly(DescriptorUtils.getFqName(classDescriptor));
    }

    public final ClassDescriptor mapJavaToKotlin(FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num) {
        ClassId classIdMapJavaToKotlin;
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (num == null || !Intrinsics3.areEqual(fqName, JavaToKotlinClassMap.a.getFUNCTION_N_FQ_NAME())) {
            classIdMapJavaToKotlin = JavaToKotlinClassMap.a.mapJavaToKotlin(fqName);
        } else {
            StandardNames standardNames = StandardNames.a;
            classIdMapJavaToKotlin = StandardNames.getFunctionClassId(num.intValue());
        }
        if (classIdMapJavaToKotlin != null) {
            return kotlinBuiltIns.getBuiltInClassByFqName(classIdMapJavaToKotlin.asSingleFqName());
        }
        return null;
    }

    public final Collection<ClassDescriptor> mapPlatformClass(FqName fqName, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        ClassDescriptor classDescriptorMapJavaToKotlin$default = mapJavaToKotlin$default(this, fqName, kotlinBuiltIns, null, 4, null);
        if (classDescriptorMapJavaToKotlin$default == null) {
            return Sets5.emptySet();
        }
        FqName onlyToMutable = JavaToKotlinClassMap.a.readOnlyToMutable(DescriptorUtils2.getFqNameUnsafe(classDescriptorMapJavaToKotlin$default));
        if (onlyToMutable == null) {
            return SetsJVM.setOf(classDescriptorMapJavaToKotlin$default);
        }
        ClassDescriptor builtInClassByFqName = kotlinBuiltIns.getBuiltInClassByFqName(onlyToMutable);
        Intrinsics3.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)");
        return Collections2.listOf((Object[]) new ClassDescriptor[]{classDescriptorMapJavaToKotlin$default, builtInClassByFqName});
    }

    public final boolean isMutable(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor(kotlinType);
        return classDescriptor != null && isMutable(classDescriptor);
    }

    public final boolean isReadOnly(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor(kotlinType);
        return classDescriptor != null && isReadOnly(classDescriptor);
    }
}
