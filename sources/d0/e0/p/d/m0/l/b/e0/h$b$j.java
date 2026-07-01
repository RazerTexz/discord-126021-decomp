package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.l.b.w;
import d0.t.o0;
import d0.z.d.o;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b$j extends o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
    public final /* synthetic */ h$b this$0;
    public final /* synthetic */ h this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$b$j(h$b h_b, h hVar) {
        super(0);
        this.this$0 = h_b;
        this.this$1 = hVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
        h$b h_b = this.this$0;
        List listAccess$getPropertyList$p = h$b.access$getPropertyList$p(h_b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        h hVar = h_b.o;
        Iterator it = listAccess$getPropertyList$p.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(w.getName(h.access$getC(hVar).getNameResolver(), ((d0.e0.p.d.m0.f.n) ((d0.e0.p.d.m0.i.n) it.next())).getName()));
        }
        return o0.plus((Set) linkedHashSet, (Iterable) this.this$1.h());
    }
}
