package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.j0;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends d0.z.d.o implements Function0<String> {
    public final /* synthetic */ Set<j0> $inputTypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public w(Set<? extends j0> set) {
        super(0);
        this.$inputTypes = set;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return d0.z.d.m.stringPlus("This collections cannot be empty! input types: ", d0.t.u.joinToString$default(this.$inputTypes, null, null, null, 0, null, null, 63, null));
    }
}
