package b.i.a.f.c.a.f.b;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends b.i.a.f.h.c.b implements n {
    public p() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // b.i.a.f.h.c.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 101:
                throw new UnsupportedOperationException();
            case 102:
                p((Status) b.i.a.f.h.c.d.a(parcel, Status.CREATOR));
                break;
            case 103:
                v((Status) b.i.a.f.h.c.d.a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
