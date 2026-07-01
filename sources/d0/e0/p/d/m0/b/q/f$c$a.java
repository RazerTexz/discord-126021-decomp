package d0.e0.p.d.m0.b.q;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$c$a extends d0.z.d.o implements Function0<f$b> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$c$a(f fVar) {
        super(0);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ f$b invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final f$b invoke() {
        Function0 function0Access$getSettingsComputation$p = f.access$getSettingsComputation$p(this.this$0);
        if (function0Access$getSettingsComputation$p == null) {
            throw new AssertionError("JvmBuiltins instance has not been initialized properly");
        }
        f$b f_b = (f$b) function0Access$getSettingsComputation$p.invoke();
        f.access$setSettingsComputation$p(this.this$0, null);
        return f_b;
    }
}
