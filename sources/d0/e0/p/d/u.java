package d0.e0.p.d;

import d0.e0.p.d.m0.n.e1;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends d0.z.d.o implements Function0<Boolean> {
    public final /* synthetic */ s$a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(s$a s_a) {
        super(0);
        this.$this_computeCallerForAccessor = s_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return !e1.isNullableType(this.$this_computeCallerForAccessor.getProperty().getDescriptor().getType());
    }
}
