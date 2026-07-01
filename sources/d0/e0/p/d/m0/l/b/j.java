package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.f0;
import d0.e0.p.d.m0.c.h1.c$a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public final d0.e0.p.d.m0.m.o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.c.c0 f3503b;
    public final k c;
    public final g d;
    public final c<d0.e0.p.d.m0.c.g1.c, d0.e0.p.d.m0.k.v.g<?>> e;
    public final f0 f;
    public final t g;
    public final p h;
    public final d0.e0.p.d.m0.d.b.c i;
    public final q j;
    public final Iterable<d0.e0.p.d.m0.c.h1.b> k;
    public final d0 l;
    public final i m;
    public final d0.e0.p.d.m0.c.h1.a n;
    public final d0.e0.p.d.m0.c.h1.c o;
    public final d0.e0.p.d.m0.i.e p;
    public final d0.e0.p.d.m0.n.l1.l q;
    public final d0.e0.p.d.m0.k.z.a r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d0.e0.p.d.m0.c.h1.e f3504s;
    public final h t;

    /* JADX WARN: Multi-variable type inference failed */
    public j(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.c0 c0Var, k kVar, g gVar, c<? extends d0.e0.p.d.m0.c.g1.c, ? extends d0.e0.p.d.m0.k.v.g<?>> cVar, f0 f0Var, t tVar, p pVar, d0.e0.p.d.m0.d.b.c cVar2, q qVar, Iterable<? extends d0.e0.p.d.m0.c.h1.b> iterable, d0 d0Var, i iVar, d0.e0.p.d.m0.c.h1.a aVar, d0.e0.p.d.m0.c.h1.c cVar3, d0.e0.p.d.m0.i.e eVar, d0.e0.p.d.m0.n.l1.l lVar, d0.e0.p.d.m0.k.z.a aVar2, d0.e0.p.d.m0.c.h1.e eVar2) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
        d0.z.d.m.checkNotNullParameter(kVar, "configuration");
        d0.z.d.m.checkNotNullParameter(gVar, "classDataFinder");
        d0.z.d.m.checkNotNullParameter(cVar, "annotationAndConstantLoader");
        d0.z.d.m.checkNotNullParameter(f0Var, "packageFragmentProvider");
        d0.z.d.m.checkNotNullParameter(tVar, "localClassifierTypeSettings");
        d0.z.d.m.checkNotNullParameter(pVar, "errorReporter");
        d0.z.d.m.checkNotNullParameter(cVar2, "lookupTracker");
        d0.z.d.m.checkNotNullParameter(qVar, "flexibleTypeDeserializer");
        d0.z.d.m.checkNotNullParameter(iterable, "fictitiousClassDescriptorFactories");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        d0.z.d.m.checkNotNullParameter(iVar, "contractDeserializer");
        d0.z.d.m.checkNotNullParameter(aVar, "additionalClassPartsProvider");
        d0.z.d.m.checkNotNullParameter(cVar3, "platformDependentDeclarationFilter");
        d0.z.d.m.checkNotNullParameter(eVar, "extensionRegistryLite");
        d0.z.d.m.checkNotNullParameter(lVar, "kotlinTypeChecker");
        d0.z.d.m.checkNotNullParameter(aVar2, "samConversionResolver");
        d0.z.d.m.checkNotNullParameter(eVar2, "platformDependentTypeTransformer");
        this.a = oVar;
        this.f3503b = c0Var;
        this.c = kVar;
        this.d = gVar;
        this.e = cVar;
        this.f = f0Var;
        this.g = tVar;
        this.h = pVar;
        this.i = cVar2;
        this.j = qVar;
        this.k = iterable;
        this.l = d0Var;
        this.m = iVar;
        this.n = aVar;
        this.o = cVar3;
        this.p = eVar;
        this.q = lVar;
        this.r = aVar2;
        this.f3504s = eVar2;
        this.t = new h(this);
    }

    public final l createContext(e0 e0Var, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, d0.e0.p.d.m0.f.z.i iVar, d0.e0.p.d.m0.f.z.a aVar, d0.e0.p.d.m0.l.b.e0.f fVar) {
        d0.z.d.m.checkNotNullParameter(e0Var, "descriptor");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
        d0.z.d.m.checkNotNullParameter(iVar, "versionRequirementTable");
        d0.z.d.m.checkNotNullParameter(aVar, "metadataVersion");
        return new l(this, cVar, e0Var, gVar, iVar, aVar, fVar, null, d0.t.n.emptyList());
    }

    public final d0.e0.p.d.m0.c.e deserializeClass(d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        return h.deserializeClass$default(this.t, aVar, null, 2, null);
    }

    public final d0.e0.p.d.m0.c.h1.a getAdditionalClassPartsProvider() {
        return this.n;
    }

    public final c<d0.e0.p.d.m0.c.g1.c, d0.e0.p.d.m0.k.v.g<?>> getAnnotationAndConstantLoader() {
        return this.e;
    }

    public final g getClassDataFinder() {
        return this.d;
    }

    public final h getClassDeserializer() {
        return this.t;
    }

    public final k getConfiguration() {
        return this.c;
    }

    public final i getContractDeserializer() {
        return this.m;
    }

    public final p getErrorReporter() {
        return this.h;
    }

    public final d0.e0.p.d.m0.i.e getExtensionRegistryLite() {
        return this.p;
    }

    public final Iterable<d0.e0.p.d.m0.c.h1.b> getFictitiousClassDescriptorFactories() {
        return this.k;
    }

    public final q getFlexibleTypeDeserializer() {
        return this.j;
    }

    public final d0.e0.p.d.m0.n.l1.l getKotlinTypeChecker() {
        return this.q;
    }

    public final t getLocalClassifierTypeSettings() {
        return this.g;
    }

    public final d0.e0.p.d.m0.d.b.c getLookupTracker() {
        return this.i;
    }

    public final d0.e0.p.d.m0.c.c0 getModuleDescriptor() {
        return this.f3503b;
    }

    public final d0 getNotFoundClasses() {
        return this.l;
    }

    public final f0 getPackageFragmentProvider() {
        return this.f;
    }

    public final d0.e0.p.d.m0.c.h1.c getPlatformDependentDeclarationFilter() {
        return this.o;
    }

    public final d0.e0.p.d.m0.c.h1.e getPlatformDependentTypeTransformer() {
        return this.f3504s;
    }

    public final d0.e0.p.d.m0.m.o getStorageManager() {
        return this.a;
    }

    public /* synthetic */ j(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.c0 c0Var, k kVar, g gVar, c cVar, f0 f0Var, t tVar, p pVar, d0.e0.p.d.m0.d.b.c cVar2, q qVar, Iterable iterable, d0 d0Var, i iVar, d0.e0.p.d.m0.c.h1.a aVar, d0.e0.p.d.m0.c.h1.c cVar3, d0.e0.p.d.m0.i.e eVar, d0.e0.p.d.m0.n.l1.l lVar, d0.e0.p.d.m0.k.z.a aVar2, d0.e0.p.d.m0.c.h1.e eVar2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(oVar, c0Var, kVar, gVar, cVar, f0Var, tVar, pVar, cVar2, qVar, iterable, d0Var, iVar, (i & 8192) != 0 ? d0.e0.p.d.m0.c.h1.a$a.a : aVar, (i & 16384) != 0 ? c$a.a : cVar3, eVar, (65536 & i) != 0 ? d0.e0.p.d.m0.n.l1.l.f3529b.getDefault() : lVar, aVar2, (i & 262144) != 0 ? d0.e0.p.d.m0.c.h1.e$a.a : eVar2);
    }
}
