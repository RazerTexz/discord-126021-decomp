package d0.e0.p.d.m0.e.a;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d, reason: use source file name */
/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver2 extends Lambda implements Function2<d0.e0.p.d.m0.k.v.j, AnnotationQualifierApplicabilityType, Boolean> {
    public static final AnnotationTypeQualifierResolver2 j = new AnnotationTypeQualifierResolver2();

    public AnnotationTypeQualifierResolver2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.k.v.j jVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return Boolean.valueOf(invoke2(jVar, annotationQualifierApplicabilityType));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.k.v.j jVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        Intrinsics3.checkNotNullParameter(jVar, "<this>");
        Intrinsics3.checkNotNullParameter(annotationQualifierApplicabilityType, "it");
        return Intrinsics3.areEqual(jVar.getEnumEntryName().getIdentifier(), annotationQualifierApplicabilityType.getJavaTarget());
    }
}
