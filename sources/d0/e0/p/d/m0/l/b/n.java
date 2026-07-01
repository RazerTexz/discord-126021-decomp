package d0.e0.p.d.m0.l.b;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: DeserializedPackageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n extends d0.e0.p.d.m0.c.i1.a0 {
    public final d0.e0.p.d.m0.m.o o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.c0 c0Var) {
        super(c0Var, bVar);
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        this.o = oVar;
    }

    public abstract g getClassDataFinder();

    public boolean hasTopLevelClass(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.e0.p.d.m0.k.a0.i memberScope = getMemberScope();
        return (memberScope instanceof d0.e0.p.d.m0.l.b.e0.h) && ((d0.e0.p.d.m0.l.b.e0.h) memberScope).getClassNames$deserialization().contains(eVar);
    }
}
