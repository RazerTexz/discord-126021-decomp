package x.a.a.d;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: ITrustedWebActivityService.java */
/* JADX INFO: loaded from: classes.dex */
public class b$a$a implements b {
    public static b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f3854b;

    public b$a$a(IBinder iBinder) {
        this.f3854b = iBinder;
    }

    @Override // x.a.a.d.b
    public Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (!this.f3854b.transact(6, parcelObtain, parcelObtain2, 0) && b$a.getDefaultImpl() != null) {
                return b$a.getDefaultImpl().areNotificationsEnabled(bundle);
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3854b;
    }

    @Override // x.a.a.d.b
    public void cancelNotification(Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (this.f3854b.transact(3, parcelObtain, parcelObtain2, 0) || b$a.getDefaultImpl() == null) {
                parcelObtain2.readException();
            } else {
                b$a.getDefaultImpl().cancelNotification(bundle);
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.d.b
    public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
            parcelObtain.writeString(str);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            parcelObtain.writeStrongBinder(iBinder);
            if (!this.f3854b.transact(9, parcelObtain, parcelObtain2, 0) && b$a.getDefaultImpl() != null) {
                return b$a.getDefaultImpl().extraCommand(str, bundle, iBinder);
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.d.b
    public Bundle getActiveNotifications() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
            if (!this.f3854b.transact(5, parcelObtain, parcelObtain2, 0) && b$a.getDefaultImpl() != null) {
                return b$a.getDefaultImpl().getActiveNotifications();
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.d.b
    public Bundle getSmallIconBitmap() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
            if (!this.f3854b.transact(7, parcelObtain, parcelObtain2, 0) && b$a.getDefaultImpl() != null) {
                return b$a.getDefaultImpl().getSmallIconBitmap();
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.d.b
    public int getSmallIconId() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
            if (!this.f3854b.transact(4, parcelObtain, parcelObtain2, 0) && b$a.getDefaultImpl() != null) {
                return b$a.getDefaultImpl().getSmallIconId();
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // x.a.a.d.b
    public Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (!this.f3854b.transact(2, parcelObtain, parcelObtain2, 0) && b$a.getDefaultImpl() != null) {
                return b$a.getDefaultImpl().notifyNotificationWithChannel(bundle);
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
