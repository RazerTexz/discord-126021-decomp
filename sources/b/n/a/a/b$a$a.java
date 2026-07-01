package b.n.a.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: ISAService.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a$a implements b {
    public IBinder a;

    public b$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // b.n.a.a.b
    public String Q(String str, String str2, String str3, a aVar) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.msc.sa.aidl.ISAService");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = b$a.a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    @Override // b.n.a.a.b
    public boolean h0(int i, String str, Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.msc.sa.aidl.ISAService");
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(1);
            bundle.writeToParcel(parcelObtain, 0);
            if (!this.a.transact(6, parcelObtain, parcelObtain2, 0)) {
                int i2 = b$a.a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
