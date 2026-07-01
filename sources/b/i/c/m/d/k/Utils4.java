package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.i.c.m.d.k.i1, reason: use source file name */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public class Utils4<T> implements b.i.a.f.n.a<T, Void> {
    public final /* synthetic */ TaskCompletionSource a;

    public Utils4(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // b.i.a.f.n.a
    public Void a(@NonNull Task task) throws Exception {
        if (task.p()) {
            this.a.b(task.l());
            return null;
        }
        this.a.a(task.k());
        return null;
    }
}
