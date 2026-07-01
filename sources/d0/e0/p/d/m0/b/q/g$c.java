package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.t0;
import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$c extends d0.z.d.o implements Function1<d0.e0.p.d.m0.k.a0.i, Collection<? extends t0>> {
    public final /* synthetic */ d0.e0.p.d.m0.g.e $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g$c(d0.e0.p.d.m0.g.e eVar) {
        super(1);
        this.$name = eVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Collection<? extends t0> invoke(d0.e0.p.d.m0.k.a0.i iVar) {
        return invoke2(iVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<t0> invoke2(d0.e0.p.d.m0.k.a0.i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "it");
        return iVar.getContributedFunctions(this.$name, d0.e0.p.d.m0.d.b.d.FROM_BUILTINS);
    }
}
