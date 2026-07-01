package d0.e0.p.d.m0.e.a.i0.l;

import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o$b extends d0.z.d.o implements Function1<d0.e0.p.d.m0.k.a0.i, Collection<? extends d0.e0.p.d.m0.g.e>> {
    public static final o$b j = new o$b();

    public o$b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.m0.g.e> invoke(d0.e0.p.d.m0.k.a0.i iVar) {
        return invoke2(iVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<d0.e0.p.d.m0.g.e> invoke2(d0.e0.p.d.m0.k.a0.i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "it");
        return iVar.getVariableNames();
    }
}
