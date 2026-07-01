package b.i.c.s;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements b.i.a.f.n.a {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f1764b;

    public c(Context context, Intent intent) {
        this.a = context;
        this.f1764b = intent;
    }

    @Override // b.i.a.f.n.a
    public final Object a(Task task) {
        Context context = this.a;
        Intent intent = this.f1764b;
        if (!b.i.a.f.e.o.f.A0() || ((Integer) task.l()).intValue() != 402) {
            return task;
        }
        Task<Integer> taskA = f.a(context, intent);
        Executor executor = h.a;
        return taskA.i(g.j, e.a);
    }
}
