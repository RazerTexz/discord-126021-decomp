package b.i.a.f.e.h.j;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.a$b;
import b.i.a.f.e.h.h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<R extends b.i.a.f.e.h.h, A extends a$b> extends BasePendingResult<R> implements e<R> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull b.i.a.f.e.h.a<?> aVar, @NonNull b.i.a.f.e.h.c cVar) {
        super(cVar);
        b.c.a.a0.d.z(cVar, "GoogleApiClient must not be null");
        b.c.a.a0.d.z(aVar, "Api must not be null");
        if (aVar.f1350b == null) {
            throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
        }
    }

    @Override // b.i.a.f.e.h.j.e
    public final void a(@NonNull Status status) {
        b.c.a.a0.d.o(!status.w0(), "Failed result must not be success");
        g(d(status));
    }

    public abstract void k(@NonNull A a) throws RemoteException;

    public final void l(@NonNull A a) throws DeadObjectException {
        if (a instanceof b.i.a.f.e.k.y) {
            throw new NoSuchMethodError();
        }
        try {
            k(a);
        } catch (DeadObjectException e) {
            a(new Status(8, e.getLocalizedMessage(), null));
            throw e;
        } catch (RemoteException e2) {
            a(new Status(8, e2.getLocalizedMessage(), null));
        }
    }
}
