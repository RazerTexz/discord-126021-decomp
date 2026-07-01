package d0.e0.p.d.m0.l;

import d0.e0.p.d.m0.f.b;
import d0.e0.p.d.m0.f.b$b$c;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.d;
import d0.e0.p.d.m0.f.g;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.u;
import d0.e0.p.d.m0.i.e;
import d0.e0.p.d.m0.i.g$f;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SerializerExtensionProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public final e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g$f<d, List<b>> f3480b;
    public final g$f<c, List<b>> c;
    public final g$f<i, List<b>> d;
    public final g$f<n, List<b>> e;
    public final g$f<n, List<b>> f;
    public final g$f<n, List<b>> g;
    public final g$f<g, List<b>> h;
    public final g$f<n, b$b$c> i;
    public final g$f<u, List<b>> j;
    public final g$f<q, List<b>> k;
    public final g$f<s, List<b>> l;

    public a(e eVar, g$f<l, Integer> g_f, g$f<d, List<b>> g_f2, g$f<c, List<b>> g_f3, g$f<i, List<b>> g_f4, g$f<n, List<b>> g_f5, g$f<n, List<b>> g_f6, g$f<n, List<b>> g_f7, g$f<g, List<b>> g_f8, g$f<n, b$b$c> g_f9, g$f<u, List<b>> g_f10, g$f<q, List<b>> g_f11, g$f<s, List<b>> g_f12) {
        m.checkNotNullParameter(eVar, "extensionRegistry");
        m.checkNotNullParameter(g_f, "packageFqName");
        m.checkNotNullParameter(g_f2, "constructorAnnotation");
        m.checkNotNullParameter(g_f3, "classAnnotation");
        m.checkNotNullParameter(g_f4, "functionAnnotation");
        m.checkNotNullParameter(g_f5, "propertyAnnotation");
        m.checkNotNullParameter(g_f6, "propertyGetterAnnotation");
        m.checkNotNullParameter(g_f7, "propertySetterAnnotation");
        m.checkNotNullParameter(g_f8, "enumEntryAnnotation");
        m.checkNotNullParameter(g_f9, "compileTimeValue");
        m.checkNotNullParameter(g_f10, "parameterAnnotation");
        m.checkNotNullParameter(g_f11, "typeAnnotation");
        m.checkNotNullParameter(g_f12, "typeParameterAnnotation");
        this.a = eVar;
        this.f3480b = g_f2;
        this.c = g_f3;
        this.d = g_f4;
        this.e = g_f5;
        this.f = g_f6;
        this.g = g_f7;
        this.h = g_f8;
        this.i = g_f9;
        this.j = g_f10;
        this.k = g_f11;
        this.l = g_f12;
    }

    public final g$f<c, List<b>> getClassAnnotation() {
        return this.c;
    }

    public final g$f<n, b$b$c> getCompileTimeValue() {
        return this.i;
    }

    public final g$f<d, List<b>> getConstructorAnnotation() {
        return this.f3480b;
    }

    public final g$f<g, List<b>> getEnumEntryAnnotation() {
        return this.h;
    }

    public final e getExtensionRegistry() {
        return this.a;
    }

    public final g$f<i, List<b>> getFunctionAnnotation() {
        return this.d;
    }

    public final g$f<u, List<b>> getParameterAnnotation() {
        return this.j;
    }

    public final g$f<n, List<b>> getPropertyAnnotation() {
        return this.e;
    }

    public final g$f<n, List<b>> getPropertyGetterAnnotation() {
        return this.f;
    }

    public final g$f<n, List<b>> getPropertySetterAnnotation() {
        return this.g;
    }

    public final g$f<q, List<b>> getTypeAnnotation() {
        return this.k;
    }

    public final g$f<s, List<b>> getTypeParameterAnnotation() {
        return this.l;
    }
}
