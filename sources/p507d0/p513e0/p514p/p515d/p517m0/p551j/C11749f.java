package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.f */
/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11749f extends AbstractC12240o implements Function1<AbstractC11913c0, CharSequence> {
    public final /* synthetic */ C11747d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11749f(C11747d c11747d) {
        super(1);
        this.this$0 = c11747d;
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(AbstractC11913c0 abstractC11913c0) {
        C11747d c11747d = this.this$0;
        C12238m.checkNotNullExpressionValue(abstractC11913c0, "it");
        return c11747d.renderType(abstractC11913c0);
    }
}
