package b.i.a.f.h.c;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends m<b.i.a.f.c.a.d.b> {
    public final /* synthetic */ CredentialRequest l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b.i.a.f.e.h.c cVar, CredentialRequest credentialRequest) {
        super(cVar);
        this.l = credentialRequest;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final b.i.a.f.e.h.h d(Status status) {
        return new e(status, null);
    }

    @Override // b.i.a.f.h.c.m
    public final void m(Context context, t tVar) throws RemoteException {
        tVar.t(new j(this), this.l);
    }
}
