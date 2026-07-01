package x.a.a.d;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: ITrustedWebActivityCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class a$a$a implements a {
    public static a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f3853b;

    public a$a$a(IBinder iBinder) {
        this.f3853b = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3853b;
    }

    @Override // x.a.a.d.a
    public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityCallback");
            parcelObtain.writeString(str);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (this.f3853b.transact(2, parcelObtain, parcelObtain2, 0) || a$a.getDefaultImpl() == null) {
                parcelObtain2.readException();
            } else {
                a$a.getDefaultImpl().onExtraCallback(str, bundle);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
