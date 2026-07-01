package d0.e0.p.d.m0.e.a;

import d0.t.g0;
import d0.t.h0;
import d0.t.n0;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AnnotationQualifiersFqNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final d0.e0.p.d.m0.g.b a = new d0.e0.p.d.m0.g.b("javax.annotation.meta.TypeQualifierNickname");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0.e0.p.d.m0.g.b f3307b = new d0.e0.p.d.m0.g.b("javax.annotation.meta.TypeQualifier");
    public static final d0.e0.p.d.m0.g.b c = new d0.e0.p.d.m0.g.b("javax.annotation.meta.TypeQualifierDefault");
    public static final d0.e0.p.d.m0.g.b d = new d0.e0.p.d.m0.g.b("kotlin.annotations.jvm.UnderMigration");
    public static final List<a> e;
    public static final Map<d0.e0.p.d.m0.g.b, u> f;
    public static final Map<d0.e0.p.d.m0.g.b, u> g;
    public static final Set<d0.e0.p.d.m0.g.b> h;

    static {
        a aVar = a.VALUE_PARAMETER;
        List<a> listListOf = d0.t.n.listOf((Object[]) new a[]{a.FIELD, a.METHOD_RETURN_TYPE, aVar, a.TYPE_PARAMETER_BOUNDS, a.TYPE_USE});
        e = listListOf;
        d0.e0.p.d.m0.g.b jspecify_default_not_null = b0.getJSPECIFY_DEFAULT_NOT_NULL();
        d0.e0.p.d.m0.e.a.l0.h hVar = d0.e0.p.d.m0.e.a.l0.h.NOT_NULL;
        Map<d0.e0.p.d.m0.g.b, u> mapMapOf = g0.mapOf(d0.o.to(jspecify_default_not_null, new u(new d0.e0.p.d.m0.e.a.l0.i(hVar, false, 2, null), listListOf, false)));
        f = mapMapOf;
        g = h0.plus(h0.mapOf(d0.o.to(new d0.e0.p.d.m0.g.b("javax.annotation.ParametersAreNullableByDefault"), new u(new d0.e0.p.d.m0.e.a.l0.i(d0.e0.p.d.m0.e.a.l0.h.NULLABLE, false, 2, null), d0.t.m.listOf(aVar), false, 4, null)), d0.o.to(new d0.e0.p.d.m0.g.b("javax.annotation.ParametersAreNonnullByDefault"), new u(new d0.e0.p.d.m0.e.a.l0.i(hVar, false, 2, null), d0.t.m.listOf(aVar), false, 4, null))), mapMapOf);
        h = n0.setOf((Object[]) new d0.e0.p.d.m0.g.b[]{b0.getJAVAX_NONNULL_ANNOTATION(), b0.getJAVAX_CHECKFORNULL_ANNOTATION()});
    }

    public static final Map<d0.e0.p.d.m0.g.b, u> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return g;
    }

    public static final Set<d0.e0.p.d.m0.g.b> getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES() {
        return h;
    }

    public static final Map<d0.e0.p.d.m0.g.b, u> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return f;
    }

    public static final d0.e0.p.d.m0.g.b getMIGRATION_ANNOTATION_FQNAME() {
        return d;
    }

    public static final d0.e0.p.d.m0.g.b getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return c;
    }

    public static final d0.e0.p.d.m0.g.b getTYPE_QUALIFIER_FQNAME() {
        return f3307b;
    }

    public static final d0.e0.p.d.m0.g.b getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return a;
    }
}
