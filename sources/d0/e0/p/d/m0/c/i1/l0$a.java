package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d1;
import d0.e0.p.d.m0.c.u0;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l0$a {
    public l0$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final l0 createWithDestructuringDeclarations(d0.e0.p.d.m0.c.a aVar, c1 c1Var, int i, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.n.c0 c0Var, boolean z2, boolean z3, boolean z4, d0.e0.p.d.m0.n.c0 c0Var2, u0 u0Var, Function0<? extends List<? extends d1>> function0) {
        d0.z.d.m.checkNotNullParameter(aVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(c0Var, "outType");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        return function0 == null ? new l0(aVar, c1Var, i, gVar, eVar, c0Var, z2, z3, z4, c0Var2, u0Var) : new l0$b(aVar, c1Var, i, gVar, eVar, c0Var, z2, z3, z4, c0Var2, u0Var, function0);
    }
}
