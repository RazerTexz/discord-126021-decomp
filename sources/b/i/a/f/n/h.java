package b.i.a.f.n;

import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements i {
    public final CountDownLatch a = new CountDownLatch(1);

    public /* synthetic */ h(d0 d0Var) {
    }

    @Override // b.i.a.f.n.b
    public final void b() {
        this.a.countDown();
    }

    @Override // b.i.a.f.n.d
    public final void onFailure(@NonNull Exception exc) {
        this.a.countDown();
    }

    @Override // b.i.a.f.n.e
    public final void onSuccess(Object obj) {
        this.a.countDown();
    }
}
