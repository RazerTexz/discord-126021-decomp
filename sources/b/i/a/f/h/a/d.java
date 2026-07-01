package b.i.a.f.h.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements b, IInterface {
    public final IBinder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1403b = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

    public d(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // b.i.a.f.h.a.b
    public final boolean D(boolean z2) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1403b);
        int i = a.a;
        parcelObtain.writeInt(1);
        Parcel parcelC = c(2, parcelObtain);
        boolean z3 = parcelC.readInt() != 0;
        parcelC.recycle();
        return z3;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    public final Parcel c(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.a.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    @Override // b.i.a.f.h.a.b
    public final String getId() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1403b);
        Parcel parcelC = c(1, parcelObtain);
        String string = parcelC.readString();
        parcelC.recycle();
        return string;
    }
}
