package b.i.c.s;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c0 implements b.i.a.f.n.c {
    public final ScheduledFuture a;

    public c0(ScheduledFuture scheduledFuture) {
        this.a = scheduledFuture;
    }

    @Override // b.i.a.f.n.c
    public final void onComplete(Task task) {
        this.a.cancel(false);
    }
}
