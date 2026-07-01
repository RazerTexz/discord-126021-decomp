package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.b.k$a;
import d0.e0.p.d.m0.e.a.a0;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final c a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0.e0.p.d.m0.g.e f3315b;
    public static final d0.e0.p.d.m0.g.e c;
    public static final d0.e0.p.d.m0.g.e d;
    public static final Map<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.g.b> e;
    public static final Map<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.g.b> f;

    static {
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier("message");
        m.checkNotNullExpressionValue(eVarIdentifier, "identifier(\"message\")");
        f3315b = eVarIdentifier;
        d0.e0.p.d.m0.g.e eVarIdentifier2 = d0.e0.p.d.m0.g.e.identifier("allowedTargets");
        m.checkNotNullExpressionValue(eVarIdentifier2, "identifier(\"allowedTargets\")");
        c = eVarIdentifier2;
        d0.e0.p.d.m0.g.e eVarIdentifier3 = d0.e0.p.d.m0.g.e.identifier("value");
        m.checkNotNullExpressionValue(eVarIdentifier3, "identifier(\"value\")");
        d = eVarIdentifier3;
        d0.e0.p.d.m0.g.b bVar = k$a.A;
        d0.e0.p.d.m0.g.b bVar2 = a0.c;
        d0.e0.p.d.m0.g.b bVar3 = k$a.D;
        d0.e0.p.d.m0.g.b bVar4 = a0.d;
        d0.e0.p.d.m0.g.b bVar5 = k$a.E;
        d0.e0.p.d.m0.g.b bVar6 = a0.g;
        d0.e0.p.d.m0.g.b bVar7 = k$a.F;
        d0.e0.p.d.m0.g.b bVar8 = a0.f;
        e = h0.mapOf(o.to(bVar, bVar2), o.to(bVar3, bVar4), o.to(bVar5, bVar6), o.to(bVar7, bVar8));
        f = h0.mapOf(o.to(bVar2, bVar), o.to(bVar4, bVar3), o.to(a0.e, k$a.u), o.to(bVar6, bVar5), o.to(bVar8, bVar7));
    }

    public static /* synthetic */ d0.e0.p.d.m0.c.g1.c mapOrResolveJavaAnnotation$default(c cVar, d0.e0.p.d.m0.e.a.k0.a aVar, d0.e0.p.d.m0.e.a.i0.g gVar, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return cVar.mapOrResolveJavaAnnotation(aVar, gVar, z2);
    }

    public final d0.e0.p.d.m0.c.g1.c findMappedJavaAnnotation(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.e.a.k0.d dVar, d0.e0.p.d.m0.e.a.i0.g gVar) {
        d0.e0.p.d.m0.e.a.k0.a aVarFindAnnotation;
        m.checkNotNullParameter(bVar, "kotlinName");
        m.checkNotNullParameter(dVar, "annotationOwner");
        m.checkNotNullParameter(gVar, "c");
        if (m.areEqual(bVar, k$a.u)) {
            d0.e0.p.d.m0.g.b bVar2 = a0.e;
            m.checkNotNullExpressionValue(bVar2, "DEPRECATED_ANNOTATION");
            d0.e0.p.d.m0.e.a.k0.a aVarFindAnnotation2 = dVar.findAnnotation(bVar2);
            if (aVarFindAnnotation2 != null || dVar.isDeprecatedInJavaDoc()) {
                return new e(aVarFindAnnotation2, gVar);
            }
        }
        d0.e0.p.d.m0.g.b bVar3 = e.get(bVar);
        if (bVar3 == null || (aVarFindAnnotation = dVar.findAnnotation(bVar3)) == null) {
            return null;
        }
        return mapOrResolveJavaAnnotation$default(this, aVarFindAnnotation, gVar, false, 4, null);
    }

    public final d0.e0.p.d.m0.g.e getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return f3315b;
    }

    public final d0.e0.p.d.m0.g.e getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return d;
    }

    public final d0.e0.p.d.m0.g.e getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return c;
    }

    public final d0.e0.p.d.m0.c.g1.c mapOrResolveJavaAnnotation(d0.e0.p.d.m0.e.a.k0.a aVar, d0.e0.p.d.m0.e.a.i0.g gVar, boolean z2) {
        m.checkNotNullParameter(aVar, "annotation");
        m.checkNotNullParameter(gVar, "c");
        d0.e0.p.d.m0.g.a classId = aVar.getClassId();
        if (m.areEqual(classId, d0.e0.p.d.m0.g.a.topLevel(a0.c))) {
            return new i(aVar, gVar);
        }
        if (m.areEqual(classId, d0.e0.p.d.m0.g.a.topLevel(a0.d))) {
            return new h(aVar, gVar);
        }
        if (m.areEqual(classId, d0.e0.p.d.m0.g.a.topLevel(a0.g))) {
            return new b(gVar, aVar, k$a.E);
        }
        if (m.areEqual(classId, d0.e0.p.d.m0.g.a.topLevel(a0.f))) {
            return new b(gVar, aVar, k$a.F);
        }
        if (m.areEqual(classId, d0.e0.p.d.m0.g.a.topLevel(a0.e))) {
            return null;
        }
        return new d0.e0.p.d.m0.e.a.i0.l.e(gVar, aVar, z2);
    }
}
