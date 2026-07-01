package d0.e0.p.d.m0.l.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o$b extends d0.z.d.o implements Function0<Collection<? extends d0.e0.p.d.m0.g.e>> {
    public final /* synthetic */ o this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o$b(o oVar) {
        super(0);
        this.this$0 = oVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.m0.g.e> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<? extends d0.e0.p.d.m0.g.e> invoke2() {
        Collection<d0.e0.p.d.m0.g.a> allClassIds = this.this$0.getClassDataFinder().getAllClassIds();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allClassIds) {
            d0.e0.p.d.m0.g.a aVar = (d0.e0.p.d.m0.g.a) obj;
            if ((aVar.isNestedClass() || h.a.getBLACK_LIST().contains(aVar)) ? false : true) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((d0.e0.p.d.m0.g.a) it.next()).getShortClassName());
        }
        return arrayList2;
    }
}
