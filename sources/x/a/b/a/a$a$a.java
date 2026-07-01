package x.a.b.a;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: INotificationSideChannel.java */
/* JADX INFO: loaded from: classes.dex */
public class a$a$a implements a {
    public static a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f3855b;

    public a$a$a(IBinder iBinder) {
        this.f3855b = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3855b;
    }

    @Override // x.a.b.a.a
    public void cancel(String str, int i, String str2) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str2);
            if (this.f3855b.transact(2, parcelObtain, null, 1) || a$a.getDefaultImpl() == null) {
                return;
            }
            a$a.getDefaultImpl().cancel(str, i, str2);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // x.a.b.a.a
    public void cancelAll(String str) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            parcelObtain.writeString(str);
            if (this.f3855b.transact(3, parcelObtain, null, 1) || a$a.getDefaultImpl() == null) {
                return;
            }
            a$a.getDefaultImpl().cancelAll(str);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // x.a.b.a.a
    public void notify(String str, int i, String str2, Notification notification) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str2);
            if (notification != null) {
                parcelObtain.writeInt(1);
                notification.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (this.f3855b.transact(1, parcelObtain, null, 1) || a$a.getDefaultImpl() == null) {
                return;
            }
            a$a.getDefaultImpl().notify(str, i, str2, notification);
        } finally {
            parcelObtain.recycle();
        }
    }
}
