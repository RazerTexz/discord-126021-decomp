package d0.e0.p.d.m0.e.a;

/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final boolean access$isAnnotatedWithTypeQualifier(d0.e0.p.d.m0.c.e eVar) {
        return b.getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES().contains(d0.e0.p.d.m0.k.x.a.getFqNameSafe(eVar)) || eVar.getAnnotations().hasAnnotation(b.getTYPE_QUALIFIER_FQNAME());
    }
}
