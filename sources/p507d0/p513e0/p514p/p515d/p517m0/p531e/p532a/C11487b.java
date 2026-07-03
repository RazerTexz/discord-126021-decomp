package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.List;
import java.util.Map;
import java.util.Set;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.C11603i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.EnumC11602h;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.b */
/* JADX INFO: compiled from: AnnotationQualifiersFqNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11487b {

    /* JADX INFO: renamed from: a */
    public static final C11713b f23166a = new C11713b("javax.annotation.meta.TypeQualifierNickname");

    /* JADX INFO: renamed from: b */
    public static final C11713b f23167b = new C11713b("javax.annotation.meta.TypeQualifier");

    /* JADX INFO: renamed from: c */
    public static final C11713b f23168c = new C11713b("javax.annotation.meta.TypeQualifierDefault");

    /* JADX INFO: renamed from: d */
    public static final C11713b f23169d = new C11713b("kotlin.annotations.jvm.UnderMigration");

    /* JADX INFO: renamed from: e */
    public static final List<EnumC11485a> f23170e;

    /* JADX INFO: renamed from: f */
    public static final Map<C11713b, C11627u> f23171f;

    /* JADX INFO: renamed from: g */
    public static final Map<C11713b, C11627u> f23172g;

    /* JADX INFO: renamed from: h */
    public static final Set<C11713b> f23173h;

    static {
        EnumC11485a enumC11485a = EnumC11485a.VALUE_PARAMETER;
        List<EnumC11485a> listListOf = C12147n.listOf((Object[]) new EnumC11485a[]{EnumC11485a.FIELD, EnumC11485a.METHOD_RETURN_TYPE, enumC11485a, EnumC11485a.TYPE_PARAMETER_BOUNDS, EnumC11485a.TYPE_USE});
        f23170e = listListOf;
        C11713b jspecify_default_not_null = C11488b0.getJSPECIFY_DEFAULT_NOT_NULL();
        EnumC11602h enumC11602h = EnumC11602h.NOT_NULL;
        Map<C11713b, C11627u> mapMapOf = C12134g0.mapOf(C12116o.m10073to(jspecify_default_not_null, new C11627u(new C11603i(enumC11602h, false, 2, null), listListOf, false)));
        f23171f = mapMapOf;
        f23172g = C12136h0.plus(C12136h0.mapOf(C12116o.m10073to(new C11713b("javax.annotation.ParametersAreNullableByDefault"), new C11627u(new C11603i(EnumC11602h.NULLABLE, false, 2, null), C12145m.listOf(enumC11485a), false, 4, null)), C12116o.m10073to(new C11713b("javax.annotation.ParametersAreNonnullByDefault"), new C11627u(new C11603i(enumC11602h, false, 2, null), C12145m.listOf(enumC11485a), false, 4, null))), mapMapOf);
        f23173h = C12148n0.setOf((Object[]) new C11713b[]{C11488b0.getJAVAX_NONNULL_ANNOTATION(), C11488b0.getJAVAX_CHECKFORNULL_ANNOTATION()});
    }

    public static final Map<C11713b, C11627u> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return f23172g;
    }

    public static final Set<C11713b> getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES() {
        return f23173h;
    }

    public static final Map<C11713b, C11627u> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return f23171f;
    }

    public static final C11713b getMIGRATION_ANNOTATION_FQNAME() {
        return f23169d;
    }

    public static final C11713b getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return f23168c;
    }

    public static final C11713b getTYPE_QUALIFIER_FQNAME() {
        return f23167b;
    }

    public static final C11713b getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return f23166a;
    }
}
