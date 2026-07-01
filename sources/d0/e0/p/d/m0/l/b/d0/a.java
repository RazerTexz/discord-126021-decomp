package d0.e0.p.d.m0.l.b.d0;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.f.b$b$c;
import d0.e0.p.d.m0.f.g;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.u;
import d0.e0.p.d.m0.i.e;
import d0.e0.p.d.m0.i.g$f;
import d0.g0.t;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: BuiltInSerializerProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends d0.e0.p.d.m0.l.a {
    public static final a m = new a();

    /* JADX WARN: Illegal instructions before constructor call */
    public a() {
        e eVarNewInstance = e.newInstance();
        d0.e0.p.d.m0.f.y.b.registerAllExtensions(eVarNewInstance);
        m.checkNotNullExpressionValue(eVarNewInstance, "newInstance().apply(BuiltInsProtoBuf::registerAllExtensions)");
        g$f<l, Integer> g_f = d0.e0.p.d.m0.f.y.b.a;
        m.checkNotNullExpressionValue(g_f, "packageFqName");
        g$f<d0.e0.p.d.m0.f.d, List<d0.e0.p.d.m0.f.b>> g_f2 = d0.e0.p.d.m0.f.y.b.c;
        m.checkNotNullExpressionValue(g_f2, "constructorAnnotation");
        g$f<d0.e0.p.d.m0.f.c, List<d0.e0.p.d.m0.f.b>> g_f3 = d0.e0.p.d.m0.f.y.b.f3410b;
        m.checkNotNullExpressionValue(g_f3, "classAnnotation");
        g$f<i, List<d0.e0.p.d.m0.f.b>> g_f4 = d0.e0.p.d.m0.f.y.b.d;
        m.checkNotNullExpressionValue(g_f4, "functionAnnotation");
        g$f<n, List<d0.e0.p.d.m0.f.b>> g_f5 = d0.e0.p.d.m0.f.y.b.e;
        m.checkNotNullExpressionValue(g_f5, "propertyAnnotation");
        g$f<n, List<d0.e0.p.d.m0.f.b>> g_f6 = d0.e0.p.d.m0.f.y.b.f;
        m.checkNotNullExpressionValue(g_f6, "propertyGetterAnnotation");
        g$f<n, List<d0.e0.p.d.m0.f.b>> g_f7 = d0.e0.p.d.m0.f.y.b.g;
        m.checkNotNullExpressionValue(g_f7, "propertySetterAnnotation");
        g$f<g, List<d0.e0.p.d.m0.f.b>> g_f8 = d0.e0.p.d.m0.f.y.b.i;
        m.checkNotNullExpressionValue(g_f8, "enumEntryAnnotation");
        g$f<n, b$b$c> g_f9 = d0.e0.p.d.m0.f.y.b.h;
        m.checkNotNullExpressionValue(g_f9, "compileTimeValue");
        g$f<u, List<d0.e0.p.d.m0.f.b>> g_f10 = d0.e0.p.d.m0.f.y.b.j;
        m.checkNotNullExpressionValue(g_f10, "parameterAnnotation");
        g$f<q, List<d0.e0.p.d.m0.f.b>> g_f11 = d0.e0.p.d.m0.f.y.b.k;
        m.checkNotNullExpressionValue(g_f11, "typeAnnotation");
        g$f<s, List<d0.e0.p.d.m0.f.b>> g_f12 = d0.e0.p.d.m0.f.y.b.l;
        m.checkNotNullExpressionValue(g_f12, "typeParameterAnnotation");
        super(eVarNewInstance, g_f, g_f2, g_f3, g_f4, g_f5, g_f6, g_f7, g_f8, g_f9, g_f10, g_f11, g_f12);
    }

    public final String getBuiltInsFileName(d0.e0.p.d.m0.g.b bVar) {
        String strAsString;
        m.checkNotNullParameter(bVar, "fqName");
        if (bVar.isRoot()) {
            strAsString = "default-package";
        } else {
            strAsString = bVar.shortName().asString();
            m.checkNotNullExpressionValue(strAsString, "fqName.shortName().asString()");
        }
        return m.stringPlus(strAsString, ".kotlin_builtins");
    }

    public final String getBuiltInsFilePath(d0.e0.p.d.m0.g.b bVar) {
        m.checkNotNullParameter(bVar, "fqName");
        StringBuilder sb = new StringBuilder();
        String strAsString = bVar.asString();
        m.checkNotNullExpressionValue(strAsString, "fqName.asString()");
        sb.append(t.replace$default(strAsString, '.', MentionUtilsKt.SLASH_CHAR, false, 4, (Object) null));
        sb.append(MentionUtilsKt.SLASH_CHAR);
        sb.append(getBuiltInsFileName(bVar));
        return sb.toString();
    }
}
