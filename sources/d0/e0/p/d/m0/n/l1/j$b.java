package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.i1;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$b extends d0.z.d.o implements Function0<List<? extends i1>> {
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$b(j jVar) {
        super(0);
        this.this$0 = jVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends i1> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends i1> invoke2() {
        Function0 function0Access$getSupertypesComputation$p = j.access$getSupertypesComputation$p(this.this$0);
        if (function0Access$getSupertypesComputation$p == null) {
            return null;
        }
        return (List) function0Access$getSupertypesComputation$p.invoke();
    }
}
