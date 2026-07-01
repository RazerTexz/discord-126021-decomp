package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KFunctionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$c extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.x> {
    public final /* synthetic */ String $name;
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$c(j jVar, String str) {
        super(0);
        this.this$0 = jVar;
        this.$name = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.c.x invoke() {
        return this.this$0.getContainer().findFunctionDescriptor(this.$name, j.access$getSignature$p(this.this$0));
    }
}
