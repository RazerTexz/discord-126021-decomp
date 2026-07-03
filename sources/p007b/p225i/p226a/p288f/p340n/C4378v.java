package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.a.f.n.v */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4378v<TResult> implements InterfaceC4381y<TResult> {

    /* JADX INFO: renamed from: a */
    public final Executor f11516a;

    /* JADX INFO: renamed from: b */
    public final Object f11517b = new Object();

    /* JADX INFO: renamed from: c */
    public InterfaceC4361e<? super TResult> f11518c;

    public C4378v(@NonNull Executor executor, @NonNull InterfaceC4361e<? super TResult> interfaceC4361e) {
        this.f11516a = executor;
        this.f11518c = interfaceC4361e;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4381y
    /* JADX INFO: renamed from: a */
    public final void mo6030a(@NonNull Task<TResult> task) {
        if (task.mo6021p()) {
            synchronized (this.f11517b) {
                if (this.f11518c == null) {
                    return;
                }
                this.f11516a.execute(new RunnableC4377u(this, task));
            }
        }
    }
}
