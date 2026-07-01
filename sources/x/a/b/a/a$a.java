package x.a.b.a;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: INotificationSideChannel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a$a extends Binder implements a {
    private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
    public static final int TRANSACTION_cancel = 2;
    public static final int TRANSACTION_cancelAll = 3;
    public static final int TRANSACTION_notify = 1;

    public a$a() {
        attachInterface(this, DESCRIPTOR);
    }

    public static a asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new a$a$a(iBinder) : (a) iInterfaceQueryLocalInterface;
    }

    public static a getDefaultImpl() {
        return a$a$a.a;
    }

    public static boolean setDefaultImpl(a aVar) {
        if (a$a$a.a != null) {
            throw new IllegalStateException("setDefaultImpl() called twice");
        }
        if (aVar == null) {
            return false;
        }
        a$a$a.a = aVar;
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            notify(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
            return true;
        }
        if (i == 2) {
            parcel.enforceInterface(DESCRIPTOR);
            cancel(parcel.readString(), parcel.readInt(), parcel.readString());
            return true;
        }
        if (i == 3) {
            parcel.enforceInterface(DESCRIPTOR);
            cancelAll(parcel.readString());
            return true;
        }
        if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }
}
