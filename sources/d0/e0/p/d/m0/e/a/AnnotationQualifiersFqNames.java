package d0.e0.p.d.m0.e.a;

import d0.Tuples;
import d0.e0.p.d.m0.e.a.l0.NullabilityQualifierWithMigrationStatus;
import d0.e0.p.d.m0.e.a.l0.typeQualifiers3;
import d0.e0.p.d.m0.g.FqName;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.b, reason: use source file name */
/* JADX INFO: compiled from: AnnotationQualifiersFqNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationQualifiersFqNames {
    public static final FqName a = new FqName("javax.annotation.meta.TypeQualifierNickname");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FqName f3307b = new FqName("javax.annotation.meta.TypeQualifier");
    public static final FqName c = new FqName("javax.annotation.meta.TypeQualifierDefault");
    public static final FqName d = new FqName("kotlin.annotations.jvm.UnderMigration");
    public static final List<AnnotationQualifierApplicabilityType> e;
    public static final Map<FqName, AnnotationQualifiersFqNames2> f;
    public static final Map<FqName, AnnotationQualifiersFqNames2> g;
    public static final Set<FqName> h;

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        List<AnnotationQualifierApplicabilityType> listListOf = Collections2.listOf((Object[]) new AnnotationQualifierApplicabilityType[]{AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, annotationQualifierApplicabilityType, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE});
        e = listListOf;
        FqName jspecify_default_not_null = JvmAnnotationNames2.getJSPECIFY_DEFAULT_NOT_NULL();
        typeQualifiers3 typequalifiers3 = typeQualifiers3.NOT_NULL;
        Map<FqName, AnnotationQualifiersFqNames2> mapMapOf = MapsJVM.mapOf(Tuples.to(jspecify_default_not_null, new AnnotationQualifiersFqNames2(new NullabilityQualifierWithMigrationStatus(typequalifiers3, false, 2, null), listListOf, false)));
        f = mapMapOf;
        g = Maps6.plus(Maps6.mapOf(Tuples.to(new FqName("javax.annotation.ParametersAreNullableByDefault"), new AnnotationQualifiersFqNames2(new NullabilityQualifierWithMigrationStatus(typeQualifiers3.NULLABLE, false, 2, null), CollectionsJVM.listOf(annotationQualifierApplicabilityType), false, 4, null)), Tuples.to(new FqName("javax.annotation.ParametersAreNonnullByDefault"), new AnnotationQualifiersFqNames2(new NullabilityQualifierWithMigrationStatus(typequalifiers3, false, 2, null), CollectionsJVM.listOf(annotationQualifierApplicabilityType), false, 4, null))), mapMapOf);
        h = Sets5.setOf((Object[]) new FqName[]{JvmAnnotationNames2.getJAVAX_NONNULL_ANNOTATION(), JvmAnnotationNames2.getJAVAX_CHECKFORNULL_ANNOTATION()});
    }

    public static final Map<FqName, AnnotationQualifiersFqNames2> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return g;
    }

    public static final Set<FqName> getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES() {
        return h;
    }

    public static final Map<FqName, AnnotationQualifiersFqNames2> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return f;
    }

    public static final FqName getMIGRATION_ANNOTATION_FQNAME() {
        return d;
    }

    public static final FqName getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return c;
    }

    public static final FqName getTYPE_QUALIFIER_FQNAME() {
        return f3307b;
    }

    public static final FqName getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return a;
    }
}
