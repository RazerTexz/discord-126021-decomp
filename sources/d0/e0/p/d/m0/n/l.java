package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public class l extends z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0 f3526b;

    public l(z0 z0Var) {
        d0.z.d.m.checkNotNullParameter(z0Var, "substitution");
        this.f3526b = z0Var;
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean approximateCapturedTypes() {
        return this.f3526b.approximateCapturedTypes();
    }

    @Override // d0.e0.p.d.m0.n.z0
    public d0.e0.p.d.m0.c.g1.g filterAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        return this.f3526b.filterAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.z0
    public w0 get(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "key");
        return this.f3526b.get(c0Var);
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean isEmpty() {
        return this.f3526b.isEmpty();
    }

    @Override // d0.e0.p.d.m0.n.z0
    public c0 prepareTopLevelType(c0 c0Var, j1 j1Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "topLevelType");
        d0.z.d.m.checkNotNullParameter(j1Var, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return this.f3526b.prepareTopLevelType(c0Var, j1Var);
    }
}
