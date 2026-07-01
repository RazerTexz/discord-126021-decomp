package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.t.n0;
import d0.t.r;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChainedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b$a f3451b = new b$a(null);
    public final String c;
    public final i[] d;

    public b(String str, i[] iVarArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = str;
        this.d = iVarArr;
    }

    public static final /* synthetic */ i[] access$getScopes$p(b bVar) {
        return bVar.d;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        return k.flatMapClassifierNamesOrNull(d0.t.k.asIterable(this.d));
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        i[] iVarArr = this.d;
        int length = iVarArr.length;
        d0.e0.p.d.m0.c.h hVar = null;
        int i = 0;
        while (i < length) {
            i iVar = iVarArr[i];
            i++;
            d0.e0.p.d.m0.c.h contributedClassifier = iVar.getContributedClassifier(eVar, bVar);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof d0.e0.p.d.m0.c.i) || !((d0.e0.p.d.m0.c.i) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (hVar == null) {
                    hVar = contributedClassifier;
                }
            }
        }
        return hVar;
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        i[] iVarArr = this.d;
        int length = iVarArr.length;
        if (length == 0) {
            return d0.t.n.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return iVarArr[0].getContributedDescriptors(dVar, function1);
        }
        Collection<d0.e0.p.d.m0.c.m> collectionConcat = null;
        int length2 = iVarArr.length;
        while (i < length2) {
            i iVar = iVarArr[i];
            i++;
            collectionConcat = d0.e0.p.d.m0.o.n.a.concat(collectionConcat, iVar.getContributedDescriptors(dVar, function1));
        }
        return collectionConcat == null ? n0.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        i[] iVarArr = this.d;
        int length = iVarArr.length;
        if (length == 0) {
            return d0.t.n.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return iVarArr[0].getContributedFunctions(eVar, bVar);
        }
        Collection<t0> collectionConcat = null;
        int length2 = iVarArr.length;
        while (i < length2) {
            i iVar = iVarArr[i];
            i++;
            collectionConcat = d0.e0.p.d.m0.o.n.a.concat(collectionConcat, iVar.getContributedFunctions(eVar, bVar));
        }
        return collectionConcat == null ? n0.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Collection<d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        i[] iVarArr = this.d;
        int length = iVarArr.length;
        if (length == 0) {
            return d0.t.n.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return iVarArr[0].getContributedVariables(eVar, bVar);
        }
        Collection<d0.e0.p.d.m0.c.n0> collectionConcat = null;
        int length2 = iVarArr.length;
        while (i < length2) {
            i iVar = iVarArr[i];
            i++;
            collectionConcat = d0.e0.p.d.m0.o.n.a.concat(collectionConcat, iVar.getContributedVariables(eVar, bVar));
        }
        return collectionConcat == null ? n0.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        i[] iVarArr = this.d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (i iVar : iVarArr) {
            r.addAll(linkedHashSet, iVar.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        i[] iVarArr = this.d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (i iVar : iVarArr) {
            r.addAll(linkedHashSet, iVar.getVariableNames());
        }
        return linkedHashSet;
    }

    public String toString() {
        return this.c;
    }
}
