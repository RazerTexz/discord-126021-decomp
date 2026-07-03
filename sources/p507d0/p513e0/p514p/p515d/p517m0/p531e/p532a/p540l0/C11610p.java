package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.p */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11610p extends AbstractC12240o implements Function1<InterfaceC11321b, AbstractC11913c0> {

    /* JADX INFO: renamed from: $p */
    public final /* synthetic */ InterfaceC11326c1 f23491$p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11610p(InterfaceC11326c1 interfaceC11326c1) {
        super(1);
        this.f23491$p = interfaceC11326c1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final AbstractC11913c0 invoke(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "it");
        AbstractC11913c0 type = interfaceC11321b.getValueParameters().get(this.f23491$p.getIndex()).getType();
        C12238m.checkNotNullExpressionValue(type, "it.valueParameters[p.index].type");
        return type;
    }
}
