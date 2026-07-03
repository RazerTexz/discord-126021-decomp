package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import p007b.p225i.p226a.p288f.p313h.p316c.BinderC3453b;
import p007b.p225i.p226a.p288f.p313h.p316c.C3455d;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.p */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC3213p extends BinderC3453b implements InterfaceC3211n {
    public AbstractBinderC3213p() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.BinderC3453b
    /* JADX INFO: renamed from: c */
    public final boolean mo3994c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 101:
                throw new UnsupportedOperationException();
            case 102:
                mo3980p((Status) C3455d.m4396a(parcel, Status.CREATOR));
                break;
            case 103:
                mo3981v((Status) C3455d.m4396a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
