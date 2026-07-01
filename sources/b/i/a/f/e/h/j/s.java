package b.i.a.f.e.h.j;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.j.g;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public final int a;

    public s(int i) {
        this.a = i;
    }

    public static Status a(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void b(@NonNull Status status);

    public abstract void c(g.a<?> aVar) throws DeadObjectException;

    public abstract void d(@NonNull x0 x0Var, boolean z2);

    public abstract void e(@NonNull Exception exc);
}
