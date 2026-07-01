package b.i.a.f.e.h.j;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.j.g;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e0<T> extends m0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<T> f1357b;

    public e0(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.f1357b = taskCompletionSource;
    }

    @Override // b.i.a.f.e.h.j.s
    public void b(@NonNull Status status) {
        this.f1357b.a(new ApiException(status));
    }

    @Override // b.i.a.f.e.h.j.s
    public final void c(g.a<?> aVar) throws DeadObjectException {
        try {
            h(aVar);
        } catch (DeadObjectException e) {
            this.f1357b.a(new ApiException(s.a(e)));
            throw e;
        } catch (RemoteException e2) {
            this.f1357b.a(new ApiException(s.a(e2)));
        } catch (RuntimeException e3) {
            this.f1357b.a(e3);
        }
    }

    @Override // b.i.a.f.e.h.j.s
    public void e(@NonNull Exception exc) {
        this.f1357b.a(exc);
    }

    public abstract void h(g.a<?> aVar) throws RemoteException;
}
