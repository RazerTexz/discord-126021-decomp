package p007b.p225i.p226a.p288f.p340n;

import com.google.android.gms.tasks.Task;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.n.s */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4375s implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Task f11509j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4376t f11510k;

    public RunnableC4375s(C4376t c4376t, Task task) {
        this.f11510k = c4376t;
        this.f11509j = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f11510k.f11512b) {
            InterfaceC4359d interfaceC4359d = this.f11510k.f11513c;
            if (interfaceC4359d != null) {
                Exception excMo6016k = this.f11509j.mo6016k();
                Objects.requireNonNull(excMo6016k, "null reference");
                interfaceC4359d.onFailure(excMo6016k);
            }
        }
    }
}
