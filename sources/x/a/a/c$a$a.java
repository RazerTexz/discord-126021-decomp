package x.a.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IPostMessageService.java */
/* JADX INFO: loaded from: classes.dex */
public class c$a$a implements c {
    public static c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f3852b;

    public c$a$a(IBinder iBinder) {
        this.f3852b = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3852b;
    }

    @Override // x.a.a.c
    public void onMessageChannelReady(a aVar, Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.IPostMessageService");
            parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (this.f3852b.transact(2, parcelObtain, parcelObtain2, 0) || c$a.getDefaultImpl() == null) {
                parcelObtain2.readException();
            } else {
                c$a.getDefaultImpl().onMessageChannelReady(aVar, bundle);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.c
    public void onPostMessage(a aVar, String str, Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.IPostMessageService");
            parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            parcelObtain.writeString(str);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (this.f3852b.transact(3, parcelObtain, parcelObtain2, 0) || c$a.getDefaultImpl() == null) {
                parcelObtain2.readException();
            } else {
                c$a.getDefaultImpl().onPostMessage(aVar, str, bundle);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
