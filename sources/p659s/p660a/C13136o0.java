package p659s.p660a;

import kotlin.Unit;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: s.a.o0 */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13136o0 extends AbstractC13113g1<Job> {

    /* JADX INFO: renamed from: n */
    public final InterfaceC13130m0 f27879n;

    public C13136o0(Job job, InterfaceC13130m0 interfaceC13130m0) {
        super(job);
        this.f27879n = interfaceC13130m0;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27879n.dispose();
        return Unit.f27425a;
    }

    @Override // p659s.p660a.AbstractC13165y
    /* JADX INFO: renamed from: q */
    public void mo11198q(Throwable th) {
        this.f27879n.dispose();
    }

    @Override // p659s.p660a.p661a.C13028k
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("DisposeOnCompletion[");
        sbM833U.append(this.f27879n);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
