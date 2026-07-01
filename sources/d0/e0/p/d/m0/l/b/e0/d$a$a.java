package d0.e0.p.d.m0.l.b.e0;

import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a$a extends o implements Function0<List<? extends d0.e0.p.d.m0.g.e>> {
    public final /* synthetic */ List<d0.e0.p.d.m0.g.e> $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a$a(List<d0.e0.p.d.m0.g.e> list) {
        super(0);
        this.$it = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.g.e> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.p.d.m0.g.e> invoke2() {
        return this.$it;
    }
}
