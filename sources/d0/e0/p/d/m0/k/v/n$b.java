package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.a1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.y0;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$b extends d0.z.d.o implements Function0<List<j0>> {
    public final /* synthetic */ n this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$b(n nVar) {
        super(0);
        this.this$0 = nVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<j0> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<j0> invoke2() {
        j0 defaultType = this.this$0.getBuiltIns().getComparable().getDefaultType();
        d0.z.d.m.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
        List<j0> listMutableListOf = d0.t.n.mutableListOf(a1.replace$default(defaultType, d0.t.m.listOf(new y0(j1.IN_VARIANCE, n.access$getType$p(this.this$0))), null, 2, null));
        if (!n.access$isContainsOnlyUnsignedTypes(this.this$0)) {
            listMutableListOf.add(this.this$0.getBuiltIns().getNumberType());
        }
        return listMutableListOf;
    }
}
