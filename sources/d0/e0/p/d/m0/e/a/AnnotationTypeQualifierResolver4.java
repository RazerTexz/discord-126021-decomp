package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.f, reason: use source file name */
/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver4 {
    public static final boolean access$isAnnotatedWithTypeQualifier(ClassDescriptor classDescriptor) {
        return AnnotationQualifiersFqNames.getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES().contains(DescriptorUtils2.getFqNameSafe(classDescriptor)) || classDescriptor.getAnnotations().hasAnnotation(AnnotationQualifiersFqNames.getTYPE_QUALIFIER_FQNAME());
    }
}
