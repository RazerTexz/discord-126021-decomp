package p630i0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: i0.l */
/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12558l extends AbstractC12240o implements Function1<Throwable, Unit> {
    public final /* synthetic */ InterfaceC12504d $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12558l(InterfaceC12504d interfaceC12504d) {
        super(1);
        this.$this_await$inlined = interfaceC12504d;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.$this_await$inlined.cancel();
        return Unit.f27425a;
    }
}
