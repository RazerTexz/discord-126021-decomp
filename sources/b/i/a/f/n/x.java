package b.i.a.f.n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class x<TResult, TContinuationResult> implements e<TContinuationResult>, d, b, y {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f<TResult, TContinuationResult> f1601b;
    public final c0<TContinuationResult> c;

    public x(@NonNull Executor executor, @NonNull f<TResult, TContinuationResult> fVar, @NonNull c0<TContinuationResult> c0Var) {
        this.a = executor;
        this.f1601b = fVar;
        this.c = c0Var;
    }

    @Override // b.i.a.f.n.y
    public final void a(@NonNull Task<TResult> task) {
        this.a.execute(new w(this, task));
    }

    @Override // b.i.a.f.n.b
    public final void b() {
        this.c.u();
    }

    @Override // b.i.a.f.n.d
    public final void onFailure(@NonNull Exception exc) {
        this.c.t(exc);
    }

    @Override // b.i.a.f.n.e
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.c.s(tcontinuationresult);
    }
}
