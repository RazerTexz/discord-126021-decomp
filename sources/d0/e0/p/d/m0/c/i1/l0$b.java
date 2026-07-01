package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d1;
import d0.e0.p.d.m0.c.u0;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l0$b extends l0 {
    public final Lazy v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0$b(d0.e0.p.d.m0.c.a aVar, c1 c1Var, int i, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.n.c0 c0Var, boolean z2, boolean z3, boolean z4, d0.e0.p.d.m0.n.c0 c0Var2, u0 u0Var, Function0<? extends List<? extends d1>> function0) {
        super(aVar, c1Var, i, gVar, eVar, c0Var, z2, z3, z4, c0Var2, u0Var);
        d0.z.d.m.checkNotNullParameter(aVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(c0Var, "outType");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        d0.z.d.m.checkNotNullParameter(function0, "destructuringVariables");
        this.v = d0.g.lazy(function0);
    }

    @Override // d0.e0.p.d.m0.c.i1.l0, d0.e0.p.d.m0.c.c1
    public c1 copy(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.g.e eVar, int i) {
        d0.z.d.m.checkNotNullParameter(aVar, "newOwner");
        d0.z.d.m.checkNotNullParameter(eVar, "newName");
        d0.e0.p.d.m0.c.g1.g annotations = getAnnotations();
        d0.z.d.m.checkNotNullExpressionValue(annotations, "annotations");
        d0.e0.p.d.m0.n.c0 type = getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "type");
        boolean zDeclaresDefaultValue = declaresDefaultValue();
        boolean zIsCrossinline = isCrossinline();
        boolean zIsNoinline = isNoinline();
        d0.e0.p.d.m0.n.c0 varargElementType = getVarargElementType();
        u0 u0Var = u0.a;
        d0.z.d.m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
        return new l0$b(aVar, null, i, annotations, eVar, type, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, varargElementType, u0Var, new l0$b$a(this));
    }

    public final List<d1> getDestructuringVariables() {
        return (List) this.v.getValue();
    }
}
