package d0.e0.p.d.m0.k.a0;

import java.util.Collection;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SubstitutingScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a extends d0.z.d.o implements Function0<Collection<? extends d0.e0.p.d.m0.c.m>> {
    public final /* synthetic */ n this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$a(n nVar) {
        super(0);
        this.this$0 = nVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.m0.c.m> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<? extends d0.e0.p.d.m0.c.m> invoke2() {
        n nVar = this.this$0;
        return n.access$substitute(nVar, l$a.getContributedDescriptors$default(n.access$getWorkerScope$p(nVar), null, null, 3, null));
    }
}
