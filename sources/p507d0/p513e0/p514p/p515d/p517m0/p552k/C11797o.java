package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.o */
/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11797o implements Function1<InterfaceC11321b, Unit> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AbstractC11792j f24425j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ InterfaceC11321b f24426k;

    public C11797o(AbstractC11792j abstractC11792j, InterfaceC11321b interfaceC11321b) {
        this.f24425j = abstractC11792j;
        this.f24426k = interfaceC11321b;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(InterfaceC11321b interfaceC11321b) {
        this.f24425j.inheritanceConflict(this.f24426k, interfaceC11321b);
        return Unit.f27425a;
    }
}
