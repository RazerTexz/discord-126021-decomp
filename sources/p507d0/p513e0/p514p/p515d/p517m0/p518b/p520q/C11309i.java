package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.i */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11309i extends AbstractC12240o implements Function0<AbstractC11913c0> {
    public final /* synthetic */ C11307g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11309i(C11307g c11307g) {
        super(0);
        this.this$0 = c11307g;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AbstractC11913c0 invoke() {
        AbstractC11934j0 anyType = this.this$0.f22650b.getBuiltIns().getAnyType();
        C12238m.checkNotNullExpressionValue(anyType, "moduleDescriptor.builtIns.anyType");
        return anyType;
    }
}
