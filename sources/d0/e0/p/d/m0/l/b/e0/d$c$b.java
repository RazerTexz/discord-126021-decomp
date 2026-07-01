package d0.e0.p.d.m0.l.b.e0;

import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$c$b extends o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
    public final /* synthetic */ d$c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$c$b(d$c d_c) {
        super(0);
        this.this$0 = d_c;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
        return d$c.access$computeEnumMemberNames(this.this$0);
    }
}
