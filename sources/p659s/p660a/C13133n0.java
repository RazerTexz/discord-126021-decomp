package p659s.p660a;

import kotlin.Unit;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: s.a.n0 */
/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13133n0 extends AbstractC13120j {

    /* JADX INFO: renamed from: j */
    public final InterfaceC13130m0 f27876j;

    public C13133n0(InterfaceC13130m0 interfaceC13130m0) {
        this.f27876j = interfaceC13130m0;
    }

    @Override // p659s.p660a.AbstractC13123k
    /* JADX INFO: renamed from: a */
    public void mo11193a(Throwable th) {
        this.f27876j.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27876j.dispose();
        return Unit.f27425a;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("DisposeOnCancel[");
        sbM833U.append(this.f27876j);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
