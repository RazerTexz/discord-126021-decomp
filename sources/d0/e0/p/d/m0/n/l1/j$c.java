package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.i1;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$c extends d0.z.d.o implements Function0<List<? extends i1>> {
    public final /* synthetic */ List<i1> $supertypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j$c(List<? extends i1> list) {
        super(0);
        this.$supertypes = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends i1> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends i1> invoke2() {
        return this.$supertypes;
    }
}
