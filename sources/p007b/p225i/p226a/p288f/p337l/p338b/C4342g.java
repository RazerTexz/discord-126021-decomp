package p007b.p225i.p226a.p288f.p337l.p338b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.signin.internal.zak;
import p007b.p225i.p226a.p288f.p313h.p318e.BinderC3477a;
import p007b.p225i.p226a.p288f.p313h.p318e.C3478b;

/* JADX INFO: renamed from: b.i.a.f.l.b.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4342g implements InterfaceC4340e, IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f11452a;

    /* JADX INFO: renamed from: b */
    public final String f11453b = "com.google.android.gms.signin.internal.ISignInService";

    public C4342g(IBinder iBinder) {
        this.f11452a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f11452a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p225i.p226a.p288f.p337l.p338b.InterfaceC4340e
    /* JADX INFO: renamed from: f0 */
    public final void mo6000f0(zak zakVar, InterfaceC4338c interfaceC4338c) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f11453b);
        int i = C3478b.f9647a;
        parcelObtain.writeInt(1);
        zakVar.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder((BinderC3477a) interfaceC4338c);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.f11452a.transact(12, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
