package d0.e0.p;

import d0.e0.KClass;
import d0.e0.KClassifier;
import d0.e0.KTypeParameter;
import d0.e0.p.d.KTypeImpl;
import d0.e0.p.d.KotlinReflectionInternalError;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.KType;

/* JADX INFO: renamed from: d0.e0.p.a, reason: use source file name */
/* JADX INFO: compiled from: KTypesJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KTypesJvm {
    public static final KClass<?> getJvmErasure(KType kType) {
        KClass<?> jvmErasure;
        Intrinsics3.checkNotNullParameter(kType, "$this$jvmErasure");
        KClassifier classifier = kType.getClassifier();
        if (classifier != null && (jvmErasure = getJvmErasure(classifier)) != null) {
            return jvmErasure;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kType);
    }

    public static final KClass<?> getJvmErasure(KClassifier kClassifier) {
        Object obj;
        KClass<?> jvmErasure;
        Intrinsics3.checkNotNullParameter(kClassifier, "$this$jvmErasure");
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        if (!(kClassifier instanceof KTypeParameter)) {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kClassifier);
        }
        List<KType> upperBounds = ((KTypeParameter) kClassifier).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            KType kType = (KType) next;
            Objects.requireNonNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            ClassifierDescriptor declarationDescriptor = ((KTypeImpl) kType).getType().getConstructor().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = (ClassDescriptor) (declarationDescriptor instanceof ClassDescriptor ? declarationDescriptor : null);
            if ((classDescriptor == null || classDescriptor.getKind() == ClassKind.INTERFACE || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) ? false : true) {
                obj = next;
                break;
            }
        }
        KType kType2 = (KType) obj;
        if (kType2 == null) {
            kType2 = (KType) _Collections.firstOrNull((List) upperBounds);
        }
        return (kType2 == null || (jvmErasure = getJvmErasure(kType2)) == null) ? Reflection2.getOrCreateKotlinClass(Object.class) : jvmErasure;
    }
}
