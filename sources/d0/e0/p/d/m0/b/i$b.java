package d0.e0.p.d.m0.b;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PrimitiveType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$b extends d0.z.d.o implements Function0<d0.e0.p.d.m0.g.b> {
    public final /* synthetic */ i this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i$b(i iVar) {
        super(0);
        this.this$0 = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.g.b invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.g.b invoke() {
        d0.e0.p.d.m0.g.b bVarChild = k.l.child(this.this$0.getArrayTypeName());
        d0.z.d.m.checkNotNullExpressionValue(bVarChild, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
        return bVarChild;
    }
}
