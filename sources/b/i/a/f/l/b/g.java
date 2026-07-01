package b.i.a.f.l.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.signin.internal.zak;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements e, IInterface {
    public final IBinder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1589b = "com.google.android.gms.signin.internal.ISignInService";

    public g(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.a.f.l.b.e
    public final void f0(zak zakVar, c cVar) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1589b);
        int i = b.i.a.f.h.e.b.a;
        parcelObtain.writeInt(1);
        zakVar.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder((b.i.a.f.h.e.a) cVar);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(12, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
