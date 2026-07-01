package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import java.util.Collection;

/* JADX INFO: compiled from: PrimitiveTypeUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static final Collection<c0> getAllSignedLiteralTypes(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        return d0.t.n.listOf((Object[]) new j0[]{c0Var.getBuiltIns().getIntType(), c0Var.getBuiltIns().getLongType(), c0Var.getBuiltIns().getByteType(), c0Var.getBuiltIns().getShortType()});
    }
}
