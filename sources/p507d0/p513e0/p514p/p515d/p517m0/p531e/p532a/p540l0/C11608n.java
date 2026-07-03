package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.n */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11608n extends AbstractC12240o implements Function1<InterfaceC11321b, AbstractC11913c0> {

    /* JADX INFO: renamed from: j */
    public static final C11608n f23489j = new C11608n();

    public C11608n() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final AbstractC11913c0 invoke(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "it");
        InterfaceC11459q0 extensionReceiverParameter = interfaceC11321b.getExtensionReceiverParameter();
        C12238m.checkNotNull(extensionReceiverParameter);
        AbstractC11913c0 type = extensionReceiverParameter.getType();
        C12238m.checkNotNullExpressionValue(type, "it.extensionReceiverParameter!!.type");
        return type;
    }
}
