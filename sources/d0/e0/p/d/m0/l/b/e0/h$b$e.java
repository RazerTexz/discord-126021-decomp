package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.n0;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b$e extends o implements Function0<List<? extends n0>> {
    public final /* synthetic */ h$b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$b$e(h$b h_b) {
        super(0);
        this.this$0 = h_b;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends n0> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends n0> invoke2() {
        return h$b.access$computeProperties(this.this$0);
    }
}
