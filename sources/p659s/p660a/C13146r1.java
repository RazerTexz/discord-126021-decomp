package p659s.p660a;

import kotlin.Unit;
import p007b.p100d.p104b.p105a.C1643a;
import p659s.p660a.p661a.C13028k;

/* JADX INFO: renamed from: s.a.r1 */
/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13146r1 extends AbstractC13092e {

    /* JADX INFO: renamed from: j */
    public final C13028k f27896j;

    public C13146r1(C13028k c13028k) {
        this.f27896j = c13028k;
    }

    @Override // p659s.p660a.AbstractC13123k
    /* JADX INFO: renamed from: a */
    public void mo11193a(Throwable th) {
        this.f27896j.mo11151n();
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27896j.mo11151n();
        return Unit.f27425a;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RemoveOnCancel[");
        sbM833U.append(this.f27896j);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
