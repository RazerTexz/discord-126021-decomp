package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.d1;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l0$b$a extends d0.z.d.o implements Function0<List<? extends d1>> {
    public final /* synthetic */ l0$b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0$b$a(l0$b l0_b) {
        super(0);
        this.this$0 = l0_b;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d1> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d1> invoke2() {
        return this.this$0.getDestructuringVariables();
    }
}
