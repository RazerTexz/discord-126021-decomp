package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.g.FqName;
import d0.z.d.Intrinsics3;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.h, reason: use source file name */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DescriptorRenderer4 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.h$a */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class a {
        public static boolean getIncludeAnnotationArguments(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "this");
            return descriptorRenderer4.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
        }

        public static boolean getIncludeEmptyAnnotationArguments(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "this");
            return descriptorRenderer4.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
        }
    }

    DescriptorRenderer getAnnotationArgumentsRenderingPolicy();

    boolean getDebugMode();

    boolean getEnhancedTypes();

    Set<FqName> getExcludedTypeAnnotationClasses();

    void setAnnotationArgumentsRenderingPolicy(DescriptorRenderer descriptorRenderer);

    void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy);

    void setDebugMode(boolean z2);

    void setExcludedTypeAnnotationClasses(Set<FqName> set);

    void setModifiers(Set<? extends DescriptorRenderer3> set);

    void setParameterNameRenderingPolicy(DescriptorRenderer7 descriptorRenderer7);

    void setReceiverAfterName(boolean z2);

    void setRenderCompanionObjectName(boolean z2);

    void setStartFromName(boolean z2);

    void setTextFormat(DescriptorRenderer9 descriptorRenderer9);

    void setWithDefinedIn(boolean z2);

    void setWithoutSuperTypes(boolean z2);

    void setWithoutTypeParameters(boolean z2);
}
