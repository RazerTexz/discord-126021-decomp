package d0.e0.p.d.m0.l.b.e0;

import d0.t.o0;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$c$b extends o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
    public final /* synthetic */ h$c this$0;
    public final /* synthetic */ h this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$c$b(h$c h_c, h hVar) {
        super(0);
        this.this$0 = h_c;
        this.this$1 = hVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
        return o0.plus(h$c.access$getFunctionProtosBytes$p(this.this$0).keySet(), (Iterable) this.this$1.g());
    }
}
