package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.t0;
import d0.t.u;
import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$g extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends t0>> {
    public final /* synthetic */ t0 $function;
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$g(t0 t0Var, h hVar) {
        super(1);
        this.$function = t0Var;
        this.this$0 = hVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Collection<? extends t0> invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<t0> invoke2(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "accessorName");
        return d0.z.d.m.areEqual(this.$function.getName(), eVar) ? d0.t.m.listOf(this.$function) : u.plus(h.access$searchMethodsByNameWithoutBuiltinMagic(this.this$0, eVar), (Iterable) h.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.this$0, eVar));
    }
}
