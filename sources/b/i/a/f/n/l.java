package b.i.a.f.n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class l<TResult, TContinuationResult> implements y<TResult> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<TResult, TContinuationResult> f1595b;
    public final c0<TContinuationResult> c;

    public l(@NonNull Executor executor, @NonNull a<TResult, TContinuationResult> aVar, @NonNull c0<TContinuationResult> c0Var) {
        this.a = executor;
        this.f1595b = aVar;
        this.c = c0Var;
    }

    @Override // b.i.a.f.n.y
    public final void a(@NonNull Task<TResult> task) {
        this.a.execute(new k(this, task));
    }
}
