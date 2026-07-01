package b.i.a.f.h.c;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends m<Status> {
    public k(b.i.a.f.e.h.c cVar) {
        super(cVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ b.i.a.f.e.h.h d(Status status) {
        return status;
    }

    @Override // b.i.a.f.h.c.m
    public final void m(Context context, t tVar) throws RemoteException {
        tVar.M(new n(this));
    }
}
