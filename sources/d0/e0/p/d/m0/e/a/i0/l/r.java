package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: LazyJavaStaticScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends k {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(d0.e0.p.d.m0.e.a.i0.g gVar) {
        super(gVar, null, 2, null);
        d0.z.d.m.checkNotNullParameter(gVar, "c");
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public void g(d0.e0.p.d.m0.g.e eVar, Collection<n0> collection) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(collection, "result");
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public q0 i() {
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public k$a l(d0.e0.p.d.m0.e.a.k0.r rVar, List<? extends z0> list, c0 c0Var, List<? extends c1> list2) {
        d0.z.d.m.checkNotNullParameter(rVar, "method");
        d0.z.d.m.checkNotNullParameter(list, "methodTypeParameters");
        d0.z.d.m.checkNotNullParameter(c0Var, "returnType");
        d0.z.d.m.checkNotNullParameter(list2, "valueParameters");
        return new k$a(c0Var, null, list2, list, false, d0.t.n.emptyList());
    }
}
