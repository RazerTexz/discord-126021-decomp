package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.a.f.n.t */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4376t<TResult> implements InterfaceC4381y<TResult> {

    /* JADX INFO: renamed from: a */
    public final Executor f11511a;

    /* JADX INFO: renamed from: b */
    public final Object f11512b = new Object();

    /* JADX INFO: renamed from: c */
    public InterfaceC4359d f11513c;

    public C4376t(@NonNull Executor executor, @NonNull InterfaceC4359d interfaceC4359d) {
        this.f11511a = executor;
        this.f11513c = interfaceC4359d;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4381y
    /* JADX INFO: renamed from: a */
    public final void mo6030a(@NonNull Task<TResult> task) {
        if (task.mo6021p() || task.mo6019n()) {
            return;
        }
        synchronized (this.f11512b) {
            if (this.f11513c == null) {
                return;
            }
            this.f11511a.execute(new RunnableC4375s(this, task));
        }
    }
}
