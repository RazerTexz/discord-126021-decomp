package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.w0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.z0;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SubstitutingScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f3463b;
    public final c1 c;
    public Map<d0.e0.p.d.m0.c.m, d0.e0.p.d.m0.c.m> d;
    public final Lazy e;

    public n(i iVar, c1 c1Var) {
        d0.z.d.m.checkNotNullParameter(iVar, "workerScope");
        d0.z.d.m.checkNotNullParameter(c1Var, "givenSubstitutor");
        this.f3463b = iVar;
        z0 substitution = c1Var.getSubstitution();
        d0.z.d.m.checkNotNullExpressionValue(substitution, "givenSubstitutor.substitution");
        this.c = d0.e0.p.d.m0.k.u.a.d.wrapWithCapturingSubstitution$default(substitution, false, 1, null).buildSubstitutor();
        this.e = d0.g.lazy(new n$a(this));
    }

    public static final /* synthetic */ i access$getWorkerScope$p(n nVar) {
        return nVar.f3463b;
    }

    public static final /* synthetic */ Collection access$substitute(n nVar, Collection collection) {
        return nVar.a(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends d0.e0.p.d.m0.c.m> Collection<D> a(Collection<? extends D> collection) {
        if (this.c.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSetNewLinkedHashSetWithExpectedSize = d0.e0.p.d.m0.p.a.newLinkedHashSetWithExpectedSize(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetNewLinkedHashSetWithExpectedSize.add(b((d0.e0.p.d.m0.c.m) it.next()));
        }
        return linkedHashSetNewLinkedHashSetWithExpectedSize;
    }

    public final <D extends d0.e0.p.d.m0.c.m> D b(D d) {
        if (this.c.isEmpty()) {
            return d;
        }
        if (this.d == null) {
            this.d = new HashMap();
        }
        Map<d0.e0.p.d.m0.c.m, d0.e0.p.d.m0.c.m> map = this.d;
        d0.z.d.m.checkNotNull(map);
        d0.e0.p.d.m0.c.m mVarSubstitute = map.get(d);
        if (mVarSubstitute == null) {
            if (!(d instanceof w0)) {
                throw new IllegalStateException(d0.z.d.m.stringPlus("Unknown descriptor in scope: ", d).toString());
            }
            mVarSubstitute = ((w0) d).substitute(this.c);
            if (mVarSubstitute == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
            }
            map.put(d, mVarSubstitute);
        }
        return (D) mVarSubstitute;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        return this.f3463b.getClassifierNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        d0.e0.p.d.m0.c.h contributedClassifier = this.f3463b.getContributedClassifier(eVar, bVar);
        if (contributedClassifier == null) {
            return null;
        }
        return (d0.e0.p.d.m0.c.h) b(contributedClassifier);
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return (Collection) this.e.getValue();
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Collection<? extends t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return a(this.f3463b.getContributedFunctions(eVar, bVar));
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Collection<? extends n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return a(this.f3463b.getContributedVariables(eVar, bVar));
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        return this.f3463b.getFunctionNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        return this.f3463b.getVariableNames();
    }
}
