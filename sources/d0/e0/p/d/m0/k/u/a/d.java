package d0.e0.p.d.m0.k.u.a;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.m.f;
import d0.e0.p.d.m0.m.o;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.f0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y0;
import d0.e0.p.d.m0.n.z;
import d0.t.k;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;

/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final w0 a(w0 w0Var, z0 z0Var) {
        if (z0Var == null || w0Var.getProjectionKind() == j1.INVARIANT) {
            return w0Var;
        }
        if (z0Var.getVariance() != w0Var.getProjectionKind()) {
            return new y0(createCapturedType(w0Var));
        }
        if (!w0Var.isStarProjection()) {
            return new y0(w0Var.getType());
        }
        o oVar = f.f3514b;
        m.checkNotNullExpressionValue(oVar, "NO_LOCKS");
        return new y0(new f0(oVar, new d$a(w0Var)));
    }

    public static final /* synthetic */ w0 access$createCapturedIfNeeded(w0 w0Var, z0 z0Var) {
        return a(w0Var, z0Var);
    }

    public static final c0 createCapturedType(w0 w0Var) {
        m.checkNotNullParameter(w0Var, "typeProjection");
        return new a(w0Var, null, false, null, 14, null);
    }

    public static final boolean isCaptured(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        return c0Var.getConstructor() instanceof b;
    }

    public static final d0.e0.p.d.m0.n.z0 wrapWithCapturingSubstitution(d0.e0.p.d.m0.n.z0 z0Var, boolean z2) {
        m.checkNotNullParameter(z0Var, "<this>");
        if (!(z0Var instanceof z)) {
            return new d$b(z2, z0Var);
        }
        z zVar = (z) z0Var;
        z0[] parameters = zVar.getParameters();
        List<Pair> listZip = k.zip(zVar.getArguments(), zVar.getParameters());
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listZip, 10));
        for (Pair pair : listZip) {
            arrayList.add(a((w0) pair.getFirst(), (z0) pair.getSecond()));
        }
        Object[] array = arrayList.toArray(new w0[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return new z(parameters, (w0[]) array, z2);
    }

    public static /* synthetic */ d0.e0.p.d.m0.n.z0 wrapWithCapturingSubstitution$default(d0.e0.p.d.m0.n.z0 z0Var, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return wrapWithCapturingSubstitution(z0Var, z2);
    }
}
