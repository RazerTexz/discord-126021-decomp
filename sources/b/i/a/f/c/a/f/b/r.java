package b.i.a.f.c.a.f.b;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends b.i.a.f.h.c.c implements o {
    public r(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // b.i.a.f.c.a.f.b.o
    public final void a0(n nVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.c.d.b(parcelC, nVar);
        b.i.a.f.h.c.d.c(parcelC, googleSignInOptions);
        g(103, parcelC);
    }

    @Override // b.i.a.f.c.a.f.b.o
    public final void k0(n nVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.c.d.b(parcelC, nVar);
        b.i.a.f.h.c.d.c(parcelC, googleSignInOptions);
        g(102, parcelC);
    }
}
