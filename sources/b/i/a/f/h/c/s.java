package b.i.a.f.h.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.internal.p001authapi.zzt;
import com.google.android.gms.internal.p001authapi.zzz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends c implements t {
    public s(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    @Override // b.i.a.f.h.c.t
    public final void L(r rVar, zzt zztVar) throws RemoteException {
        Parcel parcelC = c();
        d.b(parcelC, rVar);
        d.c(parcelC, zztVar);
        g(3, parcelC);
    }

    @Override // b.i.a.f.h.c.t
    public final void M(r rVar) throws RemoteException {
        Parcel parcelC = c();
        d.b(parcelC, rVar);
        g(4, parcelC);
    }

    @Override // b.i.a.f.h.c.t
    public final void t(r rVar, CredentialRequest credentialRequest) throws RemoteException {
        Parcel parcelC = c();
        d.b(parcelC, rVar);
        d.c(parcelC, credentialRequest);
        g(1, parcelC);
    }

    @Override // b.i.a.f.h.c.t
    public final void x(r rVar, zzz zzzVar) throws RemoteException {
        Parcel parcelC = c();
        d.b(parcelC, rVar);
        d.c(parcelC, zzzVar);
        g(2, parcelC);
    }
}
