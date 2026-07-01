package b.i.a.f.e.k;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class k {
    public static final k$b a = new t();

    public static <R extends b.i.a.f.e.h.h> Task<Void> a(b.i.a.f.e.h.d<R> dVar) {
        u uVar = new u();
        k$b k_b = a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        dVar.c(new s(dVar, taskCompletionSource, uVar, k_b));
        return taskCompletionSource.a;
    }
}
