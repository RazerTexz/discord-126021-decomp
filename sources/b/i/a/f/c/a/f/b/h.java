package b.i.a.f.c.a.f.b;

import android.os.RemoteException;
import b.i.a.f.e.h.a$b;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends k<Status> {
    public h(b.i.a.f.e.h.c cVar) {
        super(cVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ b.i.a.f.e.h.h d(Status status) {
        return status;
    }

    @Override // b.i.a.f.e.h.j.d
    public final void k(a$b a_b) throws RemoteException {
        f fVar = (f) a_b;
        ((o) fVar.w()).k0(new j(this), fVar.A);
    }
}
