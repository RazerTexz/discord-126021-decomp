package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.k.a0.b$a;
import d0.e0.p.d.m0.k.a0.i$b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s$b extends d0.z.d.o implements Function0<d0.e0.p.d.m0.k.a0.i> {
    public final /* synthetic */ s this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s$b(s sVar) {
        super(0);
        this.this$0 = sVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.k.a0.i invoke() {
        if (this.this$0.getFragments().isEmpty()) {
            return i$b.f3461b;
        }
        List<d0.e0.p.d.m0.c.e0> fragments = this.this$0.getFragments();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(fragments, 10));
        Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            arrayList.add(((d0.e0.p.d.m0.c.e0) it.next()).getMemberScope());
        }
        List listPlus = d0.t.u.plus((Collection<? extends h0>) arrayList, new h0(this.this$0.getModule(), this.this$0.getFqName()));
        b$a b_a = d0.e0.p.d.m0.k.a0.b.f3451b;
        StringBuilder sbU = b.d.b.a.a.U("package view scope for ");
        sbU.append(this.this$0.getFqName());
        sbU.append(" in ");
        sbU.append(this.this$0.getModule().getName());
        return b_a.create(sbU.toString(), listPlus);
    }
}
