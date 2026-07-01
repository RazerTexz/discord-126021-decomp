package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.w0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final c$k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f3439b;
    public static final c c;

    static {
        c$k c_k = new c$k(null);
        a = c_k;
        c_k.withOptions(c$c.j);
        c_k.withOptions(c$a.j);
        c_k.withOptions(c$b.j);
        c_k.withOptions(c$d.j);
        c_k.withOptions(c$i.j);
        f3439b = c_k.withOptions(c$f.j);
        c_k.withOptions(c$g.j);
        c_k.withOptions(c$j.j);
        c = c_k.withOptions(c$e.j);
        c_k.withOptions(c$h.j);
    }

    public static /* synthetic */ String renderAnnotation$default(c cVar, d0.e0.p.d.m0.c.g1.c cVar2, d0.e0.p.d.m0.c.g1.e eVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((i & 2) != 0) {
            eVar = null;
        }
        return cVar.renderAnnotation(cVar2, eVar);
    }

    public abstract String render(d0.e0.p.d.m0.c.m mVar);

    public abstract String renderAnnotation(d0.e0.p.d.m0.c.g1.c cVar, d0.e0.p.d.m0.c.g1.e eVar);

    public abstract String renderFlexibleType(String str, String str2, d0.e0.p.d.m0.b.h hVar);

    public abstract String renderFqName(d0.e0.p.d.m0.g.c cVar);

    public abstract String renderName(d0.e0.p.d.m0.g.e eVar, boolean z2);

    public abstract String renderType(c0 c0Var);

    public abstract String renderTypeProjection(w0 w0Var);

    public final c withOptions(Function1<? super h, Unit> function1) {
        d0.z.d.m.checkNotNullParameter(function1, "changeOptions");
        i iVarCopy = ((d) this).getOptions().copy();
        function1.invoke(iVarCopy);
        iVarCopy.lock();
        return new d(iVarCopy);
    }
}
