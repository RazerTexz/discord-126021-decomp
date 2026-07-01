package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public class j1$a<T> implements b.i.a.f.n.a<T, Void> {
    public final /* synthetic */ j1 a;

    public j1$a(j1 j1Var) {
        this.a = j1Var;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b.i.a.f.n.a
    public Void a(@NonNull Task task) throws Exception {
        if (task.p()) {
            this.a.k.a.s((TResult) task.l());
            return null;
        }
        TaskCompletionSource taskCompletionSource = this.a.k;
        taskCompletionSource.a.t(task.k());
        return null;
    }
}
