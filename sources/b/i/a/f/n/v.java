package b.i.a.f.n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class v<TResult> implements y<TResult> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1600b = new Object();
    public e<? super TResult> c;

    public v(@NonNull Executor executor, @NonNull e<? super TResult> eVar) {
        this.a = executor;
        this.c = eVar;
    }

    @Override // b.i.a.f.n.y
    public final void a(@NonNull Task<TResult> task) {
        if (task.p()) {
            synchronized (this.f1600b) {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new u(this, task));
            }
        }
    }
}
