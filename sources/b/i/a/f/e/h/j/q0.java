package b.i.a.f.e.h.j;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.j.g;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q0<ResultT> extends m0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p<a.b, ResultT> f1371b;
    public final TaskCompletionSource<ResultT> c;
    public final n d;

    public q0(int i, p<a.b, ResultT> pVar, TaskCompletionSource<ResultT> taskCompletionSource, n nVar) {
        super(i);
        this.c = taskCompletionSource;
        this.f1371b = pVar;
        this.d = nVar;
        if (i == 2 && pVar.f1369b) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // b.i.a.f.e.h.j.s
    public final void b(@NonNull Status status) {
        this.c.a(this.d.a(status));
    }

    @Override // b.i.a.f.e.h.j.s
    public final void c(g.a<?> aVar) throws DeadObjectException {
        try {
            this.f1371b.c(aVar.f1361b, this.c);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            this.c.a(this.d.a(s.a(e2)));
        } catch (RuntimeException e3) {
            this.c.a(e3);
        }
    }

    @Override // b.i.a.f.e.h.j.s
    public final void d(@NonNull x0 x0Var, boolean z2) {
        TaskCompletionSource<ResultT> taskCompletionSource = this.c;
        x0Var.f1374b.put(taskCompletionSource, Boolean.valueOf(z2));
        taskCompletionSource.a.b(new y0(x0Var, taskCompletionSource));
    }

    @Override // b.i.a.f.e.h.j.s
    public final void e(@NonNull Exception exc) {
        this.c.a(exc);
    }

    @Override // b.i.a.f.e.h.j.m0
    @Nullable
    public final Feature[] f(g.a<?> aVar) {
        return this.f1371b.a;
    }

    @Override // b.i.a.f.e.h.j.m0
    public final boolean g(g.a<?> aVar) {
        return this.f1371b.f1369b;
    }
}
