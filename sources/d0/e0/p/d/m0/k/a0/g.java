package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InnerClassesScopeWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f3458b;

    public g(i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "workerScope");
        this.f3458b = iVar;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        return this.f3458b.getClassifierNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        d0.e0.p.d.m0.c.h contributedClassifier = this.f3458b.getContributedClassifier(eVar, bVar);
        if (contributedClassifier == null) {
            return null;
        }
        d0.e0.p.d.m0.c.e eVar2 = contributedClassifier instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) contributedClassifier : null;
        if (eVar2 != null) {
            return eVar2;
        }
        if (contributedClassifier instanceof y0) {
            return (y0) contributedClassifier;
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(d dVar, Function1 function1) {
        return getContributedDescriptors(dVar, (Function1<? super d0.e0.p.d.m0.g.e, Boolean>) function1);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        return this.f3458b.getFunctionNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        return this.f3458b.getVariableNames();
    }

    public String toString() {
        return d0.z.d.m.stringPlus("Classes from ", this.f3458b);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public List<d0.e0.p.d.m0.c.h> getContributedDescriptors(d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        d dVarRestrictedToKindsOrNull = dVar.restrictedToKindsOrNull(d.a.getCLASSIFIERS_MASK());
        if (dVarRestrictedToKindsOrNull == null) {
            return d0.t.n.emptyList();
        }
        Collection<d0.e0.p.d.m0.c.m> contributedDescriptors = this.f3458b.getContributedDescriptors(dVarRestrictedToKindsOrNull, function1);
        ArrayList arrayList = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof d0.e0.p.d.m0.c.i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
