package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.n */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11314n extends AbstractC12240o implements Function1<InterfaceC11321b, Boolean> {
    public final /* synthetic */ C11307g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11314n(C11307g c11307g) {
        super(1);
        this.this$0 = c11307g;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(InterfaceC11321b interfaceC11321b) {
        return Boolean.valueOf(interfaceC11321b.getKind() == InterfaceC11321b.a.DECLARATION && this.this$0.f22651c.isMutable((InterfaceC11330e) interfaceC11321b.getContainingDeclaration()));
    }
}
