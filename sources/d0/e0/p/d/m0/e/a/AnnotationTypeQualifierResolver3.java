package d0.e0.p.d.m0.e.a;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.e, reason: use source file name */
/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver3 extends Lambda implements Function2<d0.e0.p.d.m0.k.v.j, AnnotationQualifierApplicabilityType, Boolean> {
    public final /* synthetic */ AnnotationTypeQualifierResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationTypeQualifierResolver3(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
        super(2);
        this.this$0 = annotationTypeQualifierResolver;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.k.v.j jVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return Boolean.valueOf(invoke2(jVar, annotationQualifierApplicabilityType));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.k.v.j jVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        Intrinsics3.checkNotNullParameter(jVar, "<this>");
        Intrinsics3.checkNotNullParameter(annotationQualifierApplicabilityType, "it");
        return AnnotationTypeQualifierResolver.access$toKotlinTargetNames(this.this$0, annotationQualifierApplicabilityType.getJavaTarget()).contains(jVar.getEnumEntryName().getIdentifier());
    }
}
