package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.t0;
import java.util.Collection;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class o$a$a implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends t0>> {
    public final /* synthetic */ o$a j;

    public o$a$a(o$a o_a, o oVar) {
        this.j = o_a;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Collection<? extends t0> invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Collection<? extends t0> invoke2(d0.e0.p.d.m0.g.e eVar) {
        o$a o_a = this.j;
        Objects.requireNonNull(o_a);
        if (eVar != null) {
            return o_a.c(eVar, o_a.b().getContributedFunctions(eVar, d0.e0.p.d.m0.d.b.d.FOR_NON_TRACKED_SCOPE));
        }
        o$a.a(8);
        throw null;
    }
}
