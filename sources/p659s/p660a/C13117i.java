package p659s.p660a;

import java.util.concurrent.Future;
import kotlin.Unit;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: s.a.i */
/* JADX INFO: compiled from: Future.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13117i extends AbstractC13120j {

    /* JADX INFO: renamed from: j */
    public final Future<?> f27855j;

    public C13117i(Future<?> future) {
        this.f27855j = future;
    }

    @Override // p659s.p660a.AbstractC13123k
    /* JADX INFO: renamed from: a */
    public void mo11193a(Throwable th) {
        this.f27855j.cancel(false);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27855j.cancel(false);
        return Unit.f27425a;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CancelFutureOnCancel[");
        sbM833U.append(this.f27855j);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
