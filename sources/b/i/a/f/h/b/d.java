package b.i.a.f.h.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements e, IInterface {
    public final IBinder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1405b = "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";

    public d(IBinder iBinder) {
        this.a = iBinder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.a.f.h.b.e
    public final void Y(g gVar) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1405b);
        int i = c.a;
        parcelObtain.writeStrongBinder((a) gVar);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }
}
