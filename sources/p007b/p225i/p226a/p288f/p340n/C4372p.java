package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.a.f.n.p */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4372p<TResult> implements InterfaceC4381y<TResult> {

    /* JADX INFO: renamed from: a */
    public final Executor f11501a;

    /* JADX INFO: renamed from: b */
    public final Object f11502b = new Object();

    /* JADX INFO: renamed from: c */
    public InterfaceC4355b f11503c;

    public C4372p(@NonNull Executor executor, @NonNull InterfaceC4355b interfaceC4355b) {
        this.f11501a = executor;
        this.f11503c = interfaceC4355b;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4381y
    /* JADX INFO: renamed from: a */
    public final void mo6030a(@NonNull Task<TResult> task) {
        if (task.mo6019n()) {
            synchronized (this.f11502b) {
                if (this.f11503c == null) {
                    return;
                }
                this.f11501a.execute(new RunnableC4371o(this));
            }
        }
    }
}
