package d0.e0.p.d.m0.n;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypeAliasExpansion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r0 {
    public static final r0$a a = new r0$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f3537b;
    public final d0.e0.p.d.m0.c.y0 c;
    public final List<w0> d;
    public final Map<d0.e0.p.d.m0.c.z0, w0> e;

    public r0(r0 r0Var, d0.e0.p.d.m0.c.y0 y0Var, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3537b = r0Var;
        this.c = y0Var;
        this.d = list;
        this.e = map;
    }

    public final List<w0> getArguments() {
        return this.d;
    }

    public final d0.e0.p.d.m0.c.y0 getDescriptor() {
        return this.c;
    }

    public final w0 getReplacement(u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        d0.e0.p.d.m0.c.h declarationDescriptor = u0Var.getDeclarationDescriptor();
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.z0) {
            return this.e.get(declarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(d0.e0.p.d.m0.c.y0 y0Var) {
        d0.z.d.m.checkNotNullParameter(y0Var, "descriptor");
        if (!d0.z.d.m.areEqual(this.c, y0Var)) {
            r0 r0Var = this.f3537b;
            if (!(r0Var == null ? false : r0Var.isRecursion(y0Var))) {
                return false;
            }
        }
        return true;
    }
}
