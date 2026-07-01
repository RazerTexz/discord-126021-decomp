package b.i.a.f.e.k;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class k {
    public static final b a = new t();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public interface a<R extends b.i.a.f.e.h.h, T> {
        T a(R r);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public interface b {
    }

    public static <R extends b.i.a.f.e.h.h> Task<Void> a(b.i.a.f.e.h.d<R> dVar) {
        u uVar = new u();
        b bVar = a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        dVar.c(new s(dVar, taskCompletionSource, uVar, bVar));
        return taskCompletionSource.a;
    }
}
