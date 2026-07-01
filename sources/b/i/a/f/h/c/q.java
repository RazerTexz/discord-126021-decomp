package b.i.a.f.h.c;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q extends b implements r {
    public q() {
        super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    @Override // b.i.a.f.h.c.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            O((Status) d.a(parcel, Status.CREATOR), (Credential) d.a(parcel, Credential.CREATOR));
        } else {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                parcel.readString();
                throw new UnsupportedOperationException();
            }
            l((Status) d.a(parcel, Status.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
