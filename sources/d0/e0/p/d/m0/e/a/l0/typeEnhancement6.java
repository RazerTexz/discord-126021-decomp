package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.b.q.JavaToKotlinClassMapper;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.g1.Annotations6;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.x, reason: use source file name */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeEnhancement6 {
    public static final typeEnhancement2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final typeEnhancement2 f3354b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.x$a */
    /* JADX INFO: compiled from: typeEnhancement.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3355b;

        static {
            typeQualifiers2.valuesCustom();
            a = new int[]{1, 2};
            typeQualifiers3.valuesCustom();
            f3355b = new int[]{1, 2, 0};
        }
    }

    static {
        FqName fqName = JvmAnnotationNames.o;
        Intrinsics3.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        a = new typeEnhancement2(fqName);
        FqName fqName2 = JvmAnnotationNames.p;
        Intrinsics3.checkNotNullExpressionValue(fqName2, "ENHANCED_MUTABILITY_ANNOTATION");
        f3354b = new typeEnhancement2(fqName2);
    }

    public static final <T> typeEnhancement3<T> a(T t) {
        return new typeEnhancement3<>(t, null);
    }

    public static final Annotations4 access$compositeAnnotationsOrSingle(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? new Annotations6((List<? extends Annotations4>) _Collections.toList(list)) : (Annotations4) _Collections.single(list);
        }
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    public static final typeEnhancement3 access$enhanceMutability(ClassifierDescriptor classifierDescriptor, typeQualifiers typequalifiers, TypeComponentPosition typeComponentPosition) {
        typeEnhancement3 typeenhancement3;
        if (TypeComponentPosition2.shouldEnhance(typeComponentPosition) && (classifierDescriptor instanceof ClassDescriptor)) {
            JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.a;
            typeQualifiers2 mutability = typequalifiers.getMutability();
            int i = mutability == null ? -1 : a.a[mutability.ordinal()];
            if (i == 1) {
                if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
                    ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                    if (javaToKotlinClassMapper.isMutable(classDescriptor)) {
                        typeenhancement3 = new typeEnhancement3(javaToKotlinClassMapper.convertMutableToReadOnly(classDescriptor), f3354b);
                        return typeenhancement3;
                    }
                }
                return a(classifierDescriptor);
            }
            if (i == 2 && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) classifierDescriptor;
                if (javaToKotlinClassMapper.isReadOnly(classDescriptor2)) {
                    typeenhancement3 = new typeEnhancement3(javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptor2), f3354b);
                    return typeenhancement3;
                }
            }
            return a(classifierDescriptor);
        }
        return a(classifierDescriptor);
    }

    public static final typeEnhancement3 access$getEnhancedNullability(KotlinType kotlinType, typeQualifiers typequalifiers, TypeComponentPosition typeComponentPosition) {
        typeEnhancement3 typeenhancement3;
        if (!TypeComponentPosition2.shouldEnhance(typeComponentPosition)) {
            return a(Boolean.valueOf(kotlinType.isMarkedNullable()));
        }
        typeQualifiers3 nullability = typequalifiers.getNullability();
        int i = nullability == null ? -1 : a.f3355b[nullability.ordinal()];
        if (i == 1) {
            typeenhancement3 = new typeEnhancement3(Boolean.TRUE, a);
        } else {
            if (i != 2) {
                return a(Boolean.valueOf(kotlinType.isMarkedNullable()));
            }
            typeenhancement3 = new typeEnhancement3(Boolean.FALSE, a);
        }
        return typeenhancement3;
    }

    public static final boolean hasEnhancedNullability(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return typeEnchancementUtils.hasEnhancedNullability(NewKotlinTypeChecker4.a, kotlinType);
    }
}
