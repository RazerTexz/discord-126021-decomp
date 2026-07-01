package b.i.a.f.n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class p<TResult> implements y<TResult> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1597b = new Object();
    public b c;

    public p(@NonNull Executor executor, @NonNull b bVar) {
        this.a = executor;
        this.c = bVar;
    }

    @Override // b.i.a.f.n.y
    public final void a(@NonNull Task<TResult> task) {
        if (task.n()) {
            synchronized (this.f1597b) {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new o(this));
            }
        }
    }
}
