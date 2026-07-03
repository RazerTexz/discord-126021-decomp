package p659s.p660a;

import kotlin.Unit;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: s.a.q */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13141q extends AbstractC13094e1<C13116h1> implements InterfaceC13138p {

    /* JADX INFO: renamed from: n */
    public final InterfaceC13144r f27882n;

    public C13141q(C13116h1 c13116h1, InterfaceC13144r interfaceC13144r) {
        super(c13116h1);
        this.f27882n = interfaceC13144r;
    }

    @Override // p659s.p660a.InterfaceC13138p
    /* JADX INFO: renamed from: h */
    public boolean mo11333h(Throwable th) {
        return ((C13116h1) this.f27845m).mo11286E(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo11198q(th);
        return Unit.f27425a;
    }

    @Override // p659s.p660a.AbstractC13165y
    /* JADX INFO: renamed from: q */
    public void mo11198q(Throwable th) {
        this.f27882n.mo11304s((InterfaceC13143q1) this.f27845m);
    }

    @Override // p659s.p660a.p661a.C13028k
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ChildHandle[");
        sbM833U.append(this.f27882n);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
