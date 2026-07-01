package b.i.a.f.n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class t<TResult> implements y<TResult> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1599b = new Object();
    public d c;

    public t(@NonNull Executor executor, @NonNull d dVar) {
        this.a = executor;
        this.c = dVar;
    }

    @Override // b.i.a.f.n.y
    public final void a(@NonNull Task<TResult> task) {
        if (task.p() || task.n()) {
            return;
        }
        synchronized (this.f1599b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new s(this, task));
        }
    }
}
