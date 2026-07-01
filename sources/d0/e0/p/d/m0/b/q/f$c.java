package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.i1.y;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$c extends d0.z.d.o implements Function0<g> {
    public final /* synthetic */ d0.e0.p.d.m0.m.o $storageManager;
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$c(f fVar, d0.e0.p.d.m0.m.o oVar) {
        super(0);
        this.this$0 = fVar;
        this.$storageManager = oVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ g invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final g invoke() {
        y builtInsModule = this.this$0.getBuiltInsModule();
        d0.z.d.m.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
        return new g(builtInsModule, this.$storageManager, new f$c$a(this.this$0));
    }
}
