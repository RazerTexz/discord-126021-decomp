package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.d */
/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11367d extends AbstractC12240o implements Function1<AbstractC11947g, AbstractC11934j0> {
    public final /* synthetic */ AbstractC11369e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11367d(AbstractC11369e abstractC11369e) {
        super(1);
        this.this$0 = abstractC11369e;
    }

    @Override // kotlin.jvm.functions.Function1
    public final AbstractC11934j0 invoke(AbstractC11947g abstractC11947g) {
        InterfaceC11352h interfaceC11352hRefineDescriptor = abstractC11947g.refineDescriptor(this.this$0);
        if (interfaceC11352hRefineDescriptor == null) {
            return null;
        }
        return interfaceC11352hRefineDescriptor.getDefaultType();
    }
}
