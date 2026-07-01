package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.i1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$d extends d0.z.d.o implements Function0<List<? extends i1>> {
    public final /* synthetic */ g $kotlinTypeRefiner;
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$d(j jVar, g gVar) {
        super(0);
        this.this$0 = jVar;
        this.$kotlinTypeRefiner = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends i1> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends i1> invoke2() {
        List<i1> supertypes = this.this$0.getSupertypes();
        g gVar = this.$kotlinTypeRefiner;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(supertypes, 10));
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            arrayList.add(((i1) it.next()).refine(gVar));
        }
        return arrayList;
    }
}
