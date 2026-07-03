package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: b.i.a.f.n.h */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4364h implements InterfaceC4365i {

    /* JADX INFO: renamed from: a */
    public final CountDownLatch f11481a = new CountDownLatch(1);

    public /* synthetic */ C4364h(RunnableC4360d0 runnableC4360d0) {
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4355b
    /* JADX INFO: renamed from: b */
    public final void mo6005b() {
        this.f11481a.countDown();
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
    public final void onFailure(@NonNull Exception exc) {
        this.f11481a.countDown();
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
    public final void onSuccess(Object obj) {
        this.f11481a.countDown();
    }
}
