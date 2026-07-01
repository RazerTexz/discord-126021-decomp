package b.i.a.f.n;

import com.google.android.gms.tasks.Task;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements Runnable {
    public final /* synthetic */ Task j;
    public final /* synthetic */ t k;

    public s(t tVar, Task task) {
        this.k = tVar;
        this.j = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.k.f1599b) {
            d dVar = this.k.c;
            if (dVar != null) {
                Exception excK = this.j.k();
                Objects.requireNonNull(excK, "null reference");
                dVar.onFailure(excK);
            }
        }
    }
}
