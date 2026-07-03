package p659s.p660a;

import java.util.concurrent.Future;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: s.a.l0 */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13127l0 implements InterfaceC13130m0 {

    /* JADX INFO: renamed from: j */
    public final Future<?> f27873j;

    public C13127l0(Future<?> future) {
        this.f27873j = future;
    }

    @Override // p659s.p660a.InterfaceC13130m0
    public void dispose() {
        this.f27873j.cancel(false);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("DisposableFutureHandle[");
        sbM833U.append(this.f27873j);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
