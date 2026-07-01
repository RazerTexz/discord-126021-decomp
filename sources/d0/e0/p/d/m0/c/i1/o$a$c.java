package d0.e0.p.d.m0.c.i1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class o$a$c implements Function0<Collection<d0.e0.p.d.m0.c.m>> {
    public final /* synthetic */ o$a j;

    public o$a$c(o$a o_a, o oVar) {
        this.j = o_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Collection<d0.e0.p.d.m0.c.m> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Collection<d0.e0.p.d.m0.c.m> invoke2() {
        o$a o_a = this.j;
        Objects.requireNonNull(o_a);
        HashSet hashSet = new HashSet();
        for (d0.e0.p.d.m0.g.e eVar : o_a.e.t.invoke()) {
            d0.e0.p.d.m0.d.b.d dVar = d0.e0.p.d.m0.d.b.d.FOR_NON_TRACKED_SCOPE;
            hashSet.addAll(o_a.getContributedFunctions(eVar, dVar));
            hashSet.addAll(o_a.getContributedVariables(eVar, dVar));
        }
        return hashSet;
    }
}
