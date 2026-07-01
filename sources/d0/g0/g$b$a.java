package d0.g0;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$b$a extends d0.z.d.o implements Function1<Integer, e> {
    public final /* synthetic */ g$b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g$b$a(g$b g_b) {
        super(1);
        this.this$0 = g_b;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final e invoke(int i) {
        return this.this$0.get(i);
    }
}
