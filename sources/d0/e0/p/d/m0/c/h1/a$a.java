package d0.e0.p.d.m0.c.h1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.n.c0;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;

/* JADX INFO: compiled from: AdditionalClassPartsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a implements a {
    public static final a$a a = new a$a();

    @Override // d0.e0.p.d.m0.c.h1.a
    public Collection<d0.e0.p.d.m0.c.d> getConstructors(d0.e0.p.d.m0.c.e eVar) {
        m.checkNotNullParameter(eVar, "classDescriptor");
        return n.emptyList();
    }

    @Override // d0.e0.p.d.m0.c.h1.a
    public Collection<t0> getFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.e eVar2) {
        m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(eVar2, "classDescriptor");
        return n.emptyList();
    }

    @Override // d0.e0.p.d.m0.c.h1.a
    public Collection<d0.e0.p.d.m0.g.e> getFunctionsNames(d0.e0.p.d.m0.c.e eVar) {
        m.checkNotNullParameter(eVar, "classDescriptor");
        return n.emptyList();
    }

    @Override // d0.e0.p.d.m0.c.h1.a
    public Collection<c0> getSupertypes(d0.e0.p.d.m0.c.e eVar) {
        m.checkNotNullParameter(eVar, "classDescriptor");
        return n.emptyList();
    }
}
