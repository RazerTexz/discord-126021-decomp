package b.o.a.n.v;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$c<T> {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<T> f1942b = new TaskCompletionSource<>();
    public final Callable<Task<T>> c;
    public final boolean d;
    public final long e;

    public a$c(String str, Callable callable, boolean z2, long j, a$a a_a) {
        this.a = str;
        this.c = callable;
        this.d = z2;
        this.e = j;
    }
}
