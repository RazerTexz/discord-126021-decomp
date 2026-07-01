package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.c.c0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ReflectionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$c extends d0.z.d.o implements Function0<d0.e0.p.d.m0.k.a0.i> {
    public final /* synthetic */ c0 $module;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$c(c0 c0Var) {
        super(0);
        this.$module = c0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.k.a0.i invoke() {
        return this.$module.getPackage(k.i).getMemberScope();
    }
}
