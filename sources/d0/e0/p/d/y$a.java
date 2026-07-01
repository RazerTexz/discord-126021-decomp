package d0.e0.p.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KTypeParameterImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y$a extends d0.z.d.o implements Function0<List<? extends x>> {
    public final /* synthetic */ y this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y$a(y yVar) {
        super(0);
        this.this$0 = yVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends x> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends x> invoke2() {
        List<d0.e0.p.d.m0.n.c0> upperBounds = this.this$0.getDescriptor().getUpperBounds();
        d0.z.d.m.checkNotNullExpressionValue(upperBounds, "descriptor.upperBounds");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(new x((d0.e0.p.d.m0.n.c0) it.next(), null, 2, null));
        }
        return arrayList;
    }
}
