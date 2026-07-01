package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.s0, reason: use source file name */
/* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface TypeAliasExpansionReportStrategy {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.s0$a */
    /* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
    public static final class a implements TypeAliasExpansionReportStrategy {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.n.TypeAliasExpansionReportStrategy
        public void boundsViolationInSubstitution(KotlinType kotlinType, KotlinType kotlinType2, KotlinType kotlinType3, TypeParameterDescriptor typeParameterDescriptor) {
            Intrinsics3.checkNotNullParameter(kotlinType, "bound");
            Intrinsics3.checkNotNullParameter(kotlinType2, "unsubstitutedArgument");
            Intrinsics3.checkNotNullParameter(kotlinType3, "argument");
            Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        }

        @Override // d0.e0.p.d.m0.n.TypeAliasExpansionReportStrategy
        public void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "typeAlias");
            Intrinsics3.checkNotNullParameter(kotlinType, "substitutedArgument");
        }

        @Override // d0.e0.p.d.m0.n.TypeAliasExpansionReportStrategy
        public void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor) {
            Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "typeAlias");
        }

        @Override // d0.e0.p.d.m0.n.TypeAliasExpansionReportStrategy
        public void repeatedAnnotation(AnnotationDescriptor annotationDescriptor) {
            Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotation");
        }
    }

    void boundsViolationInSubstitution(KotlinType kotlinType, KotlinType kotlinType2, KotlinType kotlinType3, TypeParameterDescriptor typeParameterDescriptor);

    void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType);

    void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor);

    void repeatedAnnotation(AnnotationDescriptor annotationDescriptor);
}
