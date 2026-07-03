package p007b.p225i.p226a.p288f.p313h.p316c;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: b.i.a.f.h.c.q */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC3468q extends BinderC3453b implements InterfaceC3469r {
    public AbstractBinderC3468q() {
        super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.BinderC3453b
    /* JADX INFO: renamed from: c */
    public final boolean mo3994c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo4399O((Status) C3455d.m4396a(parcel, Status.CREATOR), (Credential) C3455d.m4396a(parcel, Credential.CREATOR));
        } else {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                parcel.readString();
                throw new UnsupportedOperationException();
            }
            mo4401l((Status) C3455d.m4396a(parcel, Status.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
