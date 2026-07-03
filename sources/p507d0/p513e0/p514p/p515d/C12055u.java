package p507d0.p513e0.p514p.p515d;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.AbstractC12053s;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: d0.e0.p.d.u */
/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12055u extends AbstractC12240o implements Function0<Boolean> {
    public final /* synthetic */ AbstractC12053s.a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12055u(AbstractC12053s.a aVar) {
        super(0);
        this.$this_computeCallerForAccessor = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return !C11920e1.isNullableType(this.$this_computeCallerForAccessor.getProperty().getDescriptor().getType());
    }
}
