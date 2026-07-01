package b.i.a.f.j.b.e;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements b.i.a.f.n.c<Boolean> {
    public final /* synthetic */ TaskCompletionSource a;

    public u(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // b.i.a.f.n.c
    public final void onComplete(@NonNull Task<Boolean> task) {
        if (task.p()) {
            this.a.a.s(null);
            return;
        }
        TaskCompletionSource taskCompletionSource = this.a;
        taskCompletionSource.a.t(task.k());
    }
}
