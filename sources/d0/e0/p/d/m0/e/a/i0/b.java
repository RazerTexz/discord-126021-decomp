package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.x0;
import d0.e0.p.d.m0.e.a.l0.l;
import d0.e0.p.d.m0.e.a.s;
import d0.e0.p.d.m0.e.a.t;
import d0.e0.p.d.m0.e.b.n;
import d0.e0.p.d.m0.e.b.v;
import d0.e0.p.d.m0.l.b.p;
import d0.e0.p.d.m0.m.o;
import d0.z.d.m;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f3320b;
    public final n c;
    public final d0.e0.p.d.m0.e.b.f d;
    public final d0.e0.p.d.m0.e.a.g0.j e;
    public final p f;
    public final d0.e0.p.d.m0.e.a.g0.g g;
    public final d0.e0.p.d.m0.e.a.g0.f h;
    public final d0.e0.p.d.m0.k.z.a i;
    public final d0.e0.p.d.m0.e.a.j0.b j;
    public final i k;
    public final v l;
    public final x0 m;
    public final d0.e0.p.d.m0.d.b.c n;
    public final c0 o;
    public final d0.e0.p.d.m0.b.j p;
    public final d0.e0.p.d.m0.e.a.c q;
    public final l r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final t f3321s;
    public final c t;
    public final d0.e0.p.d.m0.n.l1.l u;
    public final d0.e0.p.d.m0.p.e v;

    public b(o oVar, s sVar, n nVar, d0.e0.p.d.m0.e.b.f fVar, d0.e0.p.d.m0.e.a.g0.j jVar, p pVar, d0.e0.p.d.m0.e.a.g0.g gVar, d0.e0.p.d.m0.e.a.g0.f fVar2, d0.e0.p.d.m0.k.z.a aVar, d0.e0.p.d.m0.e.a.j0.b bVar, i iVar, v vVar, x0 x0Var, d0.e0.p.d.m0.d.b.c cVar, c0 c0Var, d0.e0.p.d.m0.b.j jVar2, d0.e0.p.d.m0.e.a.c cVar2, l lVar, t tVar, c cVar3, d0.e0.p.d.m0.n.l1.l lVar2, d0.e0.p.d.m0.p.e eVar) {
        m.checkNotNullParameter(oVar, "storageManager");
        m.checkNotNullParameter(sVar, "finder");
        m.checkNotNullParameter(nVar, "kotlinClassFinder");
        m.checkNotNullParameter(fVar, "deserializedDescriptorResolver");
        m.checkNotNullParameter(jVar, "signaturePropagator");
        m.checkNotNullParameter(pVar, "errorReporter");
        m.checkNotNullParameter(gVar, "javaResolverCache");
        m.checkNotNullParameter(fVar2, "javaPropertyInitializerEvaluator");
        m.checkNotNullParameter(aVar, "samConversionResolver");
        m.checkNotNullParameter(bVar, "sourceElementFactory");
        m.checkNotNullParameter(iVar, "moduleClassResolver");
        m.checkNotNullParameter(vVar, "packagePartProvider");
        m.checkNotNullParameter(x0Var, "supertypeLoopChecker");
        m.checkNotNullParameter(cVar, "lookupTracker");
        m.checkNotNullParameter(c0Var, "module");
        m.checkNotNullParameter(jVar2, "reflectionTypes");
        m.checkNotNullParameter(cVar2, "annotationTypeQualifierResolver");
        m.checkNotNullParameter(lVar, "signatureEnhancement");
        m.checkNotNullParameter(tVar, "javaClassesTracker");
        m.checkNotNullParameter(cVar3, "settings");
        m.checkNotNullParameter(lVar2, "kotlinTypeChecker");
        m.checkNotNullParameter(eVar, "javaTypeEnhancementState");
        this.a = oVar;
        this.f3320b = sVar;
        this.c = nVar;
        this.d = fVar;
        this.e = jVar;
        this.f = pVar;
        this.g = gVar;
        this.h = fVar2;
        this.i = aVar;
        this.j = bVar;
        this.k = iVar;
        this.l = vVar;
        this.m = x0Var;
        this.n = cVar;
        this.o = c0Var;
        this.p = jVar2;
        this.q = cVar2;
        this.r = lVar;
        this.f3321s = tVar;
        this.t = cVar3;
        this.u = lVar2;
        this.v = eVar;
    }

    public final d0.e0.p.d.m0.e.a.c getAnnotationTypeQualifierResolver() {
        return this.q;
    }

    public final d0.e0.p.d.m0.e.b.f getDeserializedDescriptorResolver() {
        return this.d;
    }

    public final p getErrorReporter() {
        return this.f;
    }

    public final s getFinder() {
        return this.f3320b;
    }

    public final t getJavaClassesTracker() {
        return this.f3321s;
    }

    public final d0.e0.p.d.m0.e.a.g0.f getJavaPropertyInitializerEvaluator() {
        return this.h;
    }

    public final d0.e0.p.d.m0.e.a.g0.g getJavaResolverCache() {
        return this.g;
    }

    public final d0.e0.p.d.m0.p.e getJavaTypeEnhancementState() {
        return this.v;
    }

    public final n getKotlinClassFinder() {
        return this.c;
    }

    public final d0.e0.p.d.m0.n.l1.l getKotlinTypeChecker() {
        return this.u;
    }

    public final d0.e0.p.d.m0.d.b.c getLookupTracker() {
        return this.n;
    }

    public final c0 getModule() {
        return this.o;
    }

    public final i getModuleClassResolver() {
        return this.k;
    }

    public final v getPackagePartProvider() {
        return this.l;
    }

    public final d0.e0.p.d.m0.b.j getReflectionTypes() {
        return this.p;
    }

    public final c getSettings() {
        return this.t;
    }

    public final l getSignatureEnhancement() {
        return this.r;
    }

    public final d0.e0.p.d.m0.e.a.g0.j getSignaturePropagator() {
        return this.e;
    }

    public final d0.e0.p.d.m0.e.a.j0.b getSourceElementFactory() {
        return this.j;
    }

    public final o getStorageManager() {
        return this.a;
    }

    public final x0 getSupertypeLoopChecker() {
        return this.m;
    }

    public final b replace(d0.e0.p.d.m0.e.a.g0.g gVar) {
        m.checkNotNullParameter(gVar, "javaResolverCache");
        return new b(this.a, this.f3320b, this.c, this.d, this.e, this.f, gVar, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.f3321s, this.t, this.u, this.v);
    }
}
