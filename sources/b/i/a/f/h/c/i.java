package b.i.a.f.h.c;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001authapi.zzz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends m<Status> {
    public final /* synthetic */ Credential l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(b.i.a.f.e.h.c cVar, Credential credential) {
        super(cVar);
        this.l = credential;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ b.i.a.f.e.h.h d(Status status) {
        return status;
    }

    @Override // b.i.a.f.h.c.m
    public final void m(Context context, t tVar) throws RemoteException {
        tVar.x(new n(this), new zzz(this.l));
    }
}
