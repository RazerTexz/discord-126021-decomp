package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.k.a0.c$a;
import d0.t.u;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$c extends d0.z.d.o implements Function0<Collection<? extends d0.e0.p.d.m0.c.m>> {
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$c(k kVar) {
        super(0);
        this.this$0 = kVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.m0.c.m> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<? extends d0.e0.p.d.m0.c.m> invoke2() {
        k kVar = this.this$0;
        d0.e0.p.d.m0.k.a0.d dVar = d0.e0.p.d.m0.k.a0.d.m;
        Function1<d0.e0.p.d.m0.g.e, Boolean> all_name_filter = d0.e0.p.d.m0.k.a0.i.a.getALL_NAME_FILTER();
        Objects.requireNonNull(kVar);
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(all_name_filter, "nameFilter");
        d0.e0.p.d.m0.d.b.d dVar2 = d0.e0.p.d.m0.d.b.d.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getCLASSIFIERS_MASK())) {
            for (d0.e0.p.d.m0.g.e eVar : kVar.a(dVar, all_name_filter)) {
                if (all_name_filter.invoke(eVar).booleanValue()) {
                    d0.e0.p.d.m0.p.a.addIfNotNull(linkedHashSet, kVar.getContributedClassifier(eVar, dVar2));
                }
            }
        }
        if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getFUNCTIONS_MASK()) && !dVar.getExcludes().contains(c$a.a)) {
            for (d0.e0.p.d.m0.g.e eVar2 : kVar.b(dVar, all_name_filter)) {
                if (all_name_filter.invoke(eVar2).booleanValue()) {
                    linkedHashSet.addAll(kVar.getContributedFunctions(eVar2, dVar2));
                }
            }
        }
        if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getVARIABLES_MASK()) && !dVar.getExcludes().contains(c$a.a)) {
            for (d0.e0.p.d.m0.g.e eVar3 : kVar.h(dVar, all_name_filter)) {
                if (all_name_filter.invoke(eVar3).booleanValue()) {
                    linkedHashSet.addAll(kVar.getContributedVariables(eVar3, dVar2));
                }
            }
        }
        return u.toList(linkedHashSet);
    }
}
