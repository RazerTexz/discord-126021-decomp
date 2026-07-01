package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.c0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$d extends d0.z.d.o implements Function0<f$b> {
    public final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
    public final /* synthetic */ c0 $moduleDescriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$d(c0 c0Var, boolean z2) {
        super(0);
        this.$moduleDescriptor = c0Var;
        this.$isAdditionalBuiltInsFeatureSupported = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ f$b invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final f$b invoke() {
        return new f$b(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
    }
}
