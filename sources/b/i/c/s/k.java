package b.i.c.s;

import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements b.i.a.f.n.c {
    public final CountDownLatch a;

    public k(CountDownLatch countDownLatch) {
        this.a = countDownLatch;
    }

    @Override // b.i.a.f.n.c
    public final void onComplete(Task task) {
        CountDownLatch countDownLatch = this.a;
        w wVar = FirebaseInstanceId.f3111b;
        countDownLatch.countDown();
    }
}
