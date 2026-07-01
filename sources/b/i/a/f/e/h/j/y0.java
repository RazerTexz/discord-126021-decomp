package b.i.a.f.e.h.j;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y0<TResult> implements b.i.a.f.n.c<TResult> {
    public final /* synthetic */ TaskCompletionSource a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f1376b;

    public y0(x0 x0Var, TaskCompletionSource taskCompletionSource) {
        this.f1376b = x0Var;
        this.a = taskCompletionSource;
    }

    @Override // b.i.a.f.n.c
    public final void onComplete(@NonNull Task<TResult> task) {
        this.f1376b.f1374b.remove(this.a);
    }
}
