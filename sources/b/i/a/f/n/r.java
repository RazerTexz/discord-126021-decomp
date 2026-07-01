package b.i.a.f.n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class r<TResult> implements y<TResult> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1598b = new Object();
    public c<TResult> c;

    public r(@NonNull Executor executor, @NonNull c<TResult> cVar) {
        this.a = executor;
        this.c = cVar;
    }

    @Override // b.i.a.f.n.y
    public final void a(@NonNull Task<TResult> task) {
        synchronized (this.f1598b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new q(this, task));
        }
    }
}
