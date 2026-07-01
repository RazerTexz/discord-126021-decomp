package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.t0;
import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$d extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends t0>> {
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$d(h hVar) {
        super(1);
        this.this$0 = hVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Collection<? extends t0> invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<t0> invoke2(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "it");
        return h.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.this$0, eVar);
    }
}
