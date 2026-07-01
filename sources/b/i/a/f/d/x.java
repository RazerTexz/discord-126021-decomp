package b.i.a.f.d;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class x implements b.i.a.f.n.c {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1344b;
    public final ScheduledFuture c;

    public x(b bVar, String str, ScheduledFuture scheduledFuture) {
        this.a = bVar;
        this.f1344b = str;
        this.c = scheduledFuture;
    }

    @Override // b.i.a.f.n.c
    public final void onComplete(Task task) {
        b bVar = this.a;
        String str = this.f1344b;
        ScheduledFuture scheduledFuture = this.c;
        synchronized (bVar.d) {
            bVar.d.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
