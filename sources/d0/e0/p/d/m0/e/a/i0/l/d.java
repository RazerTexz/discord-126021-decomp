package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.t.n0;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: JvmPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements d0.e0.p.d.m0.k.a0.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3326b = {a0.property1(new y(a0.getOrCreateKotlinClass(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public final d0.e0.p.d.m0.e.a.i0.g c;
    public final i d;
    public final j e;
    public final d0.e0.p.d.m0.m.j f;

    public d(d0.e0.p.d.m0.e.a.i0.g gVar, u uVar, i iVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(uVar, "jPackage");
        d0.z.d.m.checkNotNullParameter(iVar, "packageFragment");
        this.c = gVar;
        this.d = iVar;
        this.e = new j(gVar, uVar, iVar);
        this.f = gVar.getStorageManager().createLazyValue(new d$a(this));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g access$getC$p(d dVar) {
        return dVar.c;
    }

    public static final /* synthetic */ i access$getPackageFragment$p(d dVar) {
        return dVar.d;
    }

    public final d0.e0.p.d.m0.k.a0.i[] a() {
        return (d0.e0.p.d.m0.k.a0.i[]) d0.e0.p.d.m0.m.n.getValue(this.f, this, (KProperty<?>) f3326b[0]);
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        Set<d0.e0.p.d.m0.g.e> setFlatMapClassifierNamesOrNull = d0.e0.p.d.m0.k.a0.k.flatMapClassifierNamesOrNull(d0.t.k.asIterable(a()));
        if (setFlatMapClassifierNamesOrNull == null) {
            return null;
        }
        setFlatMapClassifierNamesOrNull.addAll(getJavaScope$descriptors_jvm().getClassifierNames());
        return setFlatMapClassifierNamesOrNull;
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(eVar, bVar);
        d0.e0.p.d.m0.c.e contributedClassifier = this.e.getContributedClassifier(eVar, bVar);
        if (contributedClassifier != null) {
            return contributedClassifier;
        }
        d0.e0.p.d.m0.k.a0.i[] iVarArrA = a();
        d0.e0.p.d.m0.c.h hVar = null;
        int i = 0;
        int length = iVarArrA.length;
        while (i < length) {
            d0.e0.p.d.m0.k.a0.i iVar = iVarArrA[i];
            i++;
            d0.e0.p.d.m0.c.h contributedClassifier2 = iVar.getContributedClassifier(eVar, bVar);
            if (contributedClassifier2 != null) {
                if (!(contributedClassifier2 instanceof d0.e0.p.d.m0.c.i) || !((d0.e0.p.d.m0.c.i) contributedClassifier2).isExpect()) {
                    return contributedClassifier2;
                }
                if (hVar == null) {
                    hVar = contributedClassifier2;
                }
            }
        }
        return hVar;
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        j jVar = this.e;
        d0.e0.p.d.m0.k.a0.i[] iVarArrA = a();
        Collection<d0.e0.p.d.m0.c.m> contributedDescriptors = jVar.getContributedDescriptors(dVar, function1);
        int length = iVarArrA.length;
        int i = 0;
        while (i < length) {
            d0.e0.p.d.m0.k.a0.i iVar = iVarArrA[i];
            i++;
            contributedDescriptors = d0.e0.p.d.m0.o.n.a.concat(contributedDescriptors, iVar.getContributedDescriptors(dVar, function1));
        }
        return contributedDescriptors == null ? n0.emptySet() : contributedDescriptors;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(eVar, bVar);
        j jVar = this.e;
        d0.e0.p.d.m0.k.a0.i[] iVarArrA = a();
        Collection<? extends t0> contributedFunctions = jVar.getContributedFunctions(eVar, bVar);
        int length = iVarArrA.length;
        int i = 0;
        Collection collectionConcat = contributedFunctions;
        while (i < length) {
            d0.e0.p.d.m0.k.a0.i iVar = iVarArrA[i];
            i++;
            collectionConcat = d0.e0.p.d.m0.o.n.a.concat(collectionConcat, iVar.getContributedFunctions(eVar, bVar));
        }
        return collectionConcat == null ? n0.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Collection<d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(eVar, bVar);
        j jVar = this.e;
        d0.e0.p.d.m0.k.a0.i[] iVarArrA = a();
        Collection<? extends d0.e0.p.d.m0.c.n0> contributedVariables = jVar.getContributedVariables(eVar, bVar);
        int length = iVarArrA.length;
        int i = 0;
        Collection collectionConcat = contributedVariables;
        while (i < length) {
            d0.e0.p.d.m0.k.a0.i iVar = iVarArrA[i];
            i++;
            collectionConcat = d0.e0.p.d.m0.o.n.a.concat(collectionConcat, iVar.getContributedVariables(eVar, bVar));
        }
        return collectionConcat == null ? n0.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        d0.e0.p.d.m0.k.a0.i[] iVarArrA = a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (d0.e0.p.d.m0.k.a0.i iVar : iVarArrA) {
            d0.t.r.addAll(linkedHashSet, iVar.getFunctionNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getFunctionNames());
        return linkedHashSet;
    }

    public final j getJavaScope$descriptors_jvm() {
        return this.e;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        d0.e0.p.d.m0.k.a0.i[] iVarArrA = a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (d0.e0.p.d.m0.k.a0.i iVar : iVarArrA) {
            d0.t.r.addAll(linkedHashSet, iVar.getVariableNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getVariableNames());
        return linkedHashSet;
    }

    public void recordLookup(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        d0.e0.p.d.m0.d.a.record(this.c.getComponents().getLookupTracker(), bVar, this.d, eVar);
    }
}
