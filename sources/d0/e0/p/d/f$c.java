package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$c extends d0.z.d.o implements Function0<x> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$c(f fVar) {
        super(0);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ x invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final x invoke() {
        d0.e0.p.d.m0.n.c0 returnType = this.this$0.getDescriptor().getReturnType();
        d0.z.d.m.checkNotNull(returnType);
        d0.z.d.m.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        return new x(returnType, new f$c$a(this));
    }
}
