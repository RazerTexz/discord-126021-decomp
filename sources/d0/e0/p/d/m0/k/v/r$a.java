package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.w0;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r$a {
    public r$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final g<?> create(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "argumentType");
        if (e0.isError(c0Var)) {
            return null;
        }
        c0 type = c0Var;
        int i = 0;
        while (d0.e0.p.d.m0.b.h.isArray(type)) {
            type = ((w0) d0.t.u.single((List) type.getArguments())).getType();
            d0.z.d.m.checkNotNullExpressionValue(type, "type.arguments.single().type");
            i++;
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = type.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) {
            d0.e0.p.d.m0.g.a classId = d0.e0.p.d.m0.k.x.a.getClassId(declarationDescriptor);
            return classId == null ? new r(new r$b$a(c0Var)) : new r(classId, i);
        }
        if (!(declarationDescriptor instanceof z0)) {
            return null;
        }
        d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(d0.e0.p.d.m0.b.k$a.f3217b.toSafe());
        d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(StandardNames.FqNames.any.toSafe())");
        return new r(aVar, 0);
    }
}
