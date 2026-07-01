package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.n.c1;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class q$a implements Function0<Collection<d0.e0.p.d.m0.c.x>> {
    public final /* synthetic */ c1 j;
    public final /* synthetic */ q k;

    public q$a(q qVar, c1 c1Var) {
        this.k = qVar;
        this.j = c1Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Collection<d0.e0.p.d.m0.c.x> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Collection<d0.e0.p.d.m0.c.x> invoke2() {
        d0.e0.p.d.m0.p.i iVar = new d0.e0.p.d.m0.p.i();
        Iterator<? extends d0.e0.p.d.m0.c.x> it = this.k.getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            iVar.add(it.next().substitute(this.j));
        }
        return iVar;
    }
}
