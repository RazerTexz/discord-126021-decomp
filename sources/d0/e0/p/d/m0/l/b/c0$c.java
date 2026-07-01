package d0.e0.p.d.m0.l.b;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c0$c extends d0.z.d.o implements Function1<Integer, d0.e0.p.d.m0.c.h> {
    public final /* synthetic */ c0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0$c(c0 c0Var) {
        super(1);
        this.this$0 = c0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final d0.e0.p.d.m0.c.h invoke(int i) {
        return c0.access$computeTypeAliasDescriptor(this.this$0, i);
    }
}
