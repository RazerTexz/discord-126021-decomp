package x.a.a.d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: ITrustedWebActivityService.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b$a extends Binder implements b {
    private static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityService";
    public static final int TRANSACTION_areNotificationsEnabled = 6;
    public static final int TRANSACTION_cancelNotification = 3;
    public static final int TRANSACTION_extraCommand = 9;
    public static final int TRANSACTION_getActiveNotifications = 5;
    public static final int TRANSACTION_getSmallIconBitmap = 7;
    public static final int TRANSACTION_getSmallIconId = 4;
    public static final int TRANSACTION_notifyNotificationWithChannel = 2;

    public b$a() {
        attachInterface(this, DESCRIPTOR);
    }

    public static b asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new b$a$a(iBinder) : (b) iInterfaceQueryLocalInterface;
    }

    public static b getDefaultImpl() {
        return b$a$a.a;
    }

    public static boolean setDefaultImpl(b bVar) {
        if (b$a$a.a != null) {
            throw new IllegalStateException("setDefaultImpl() called twice");
        }
        if (bVar == null) {
            return false;
        }
        b$a$a.a = bVar;
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 9) {
            parcel.enforceInterface(DESCRIPTOR);
            Bundle bundleExtraCommand = extraCommand(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
            parcel2.writeNoException();
            if (bundleExtraCommand != null) {
                parcel2.writeInt(1);
                bundleExtraCommand.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
        if (i == 1598968902) {
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
        switch (i) {
            case 2:
                parcel.enforceInterface(DESCRIPTOR);
                Bundle bundleNotifyNotificationWithChannel = notifyNotificationWithChannel(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (bundleNotifyNotificationWithChannel != null) {
                    parcel2.writeInt(1);
                    bundleNotifyNotificationWithChannel.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 3:
                parcel.enforceInterface(DESCRIPTOR);
                cancelNotification(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface(DESCRIPTOR);
                int smallIconId = getSmallIconId();
                parcel2.writeNoException();
                parcel2.writeInt(smallIconId);
                return true;
            case 5:
                parcel.enforceInterface(DESCRIPTOR);
                Bundle activeNotifications = getActiveNotifications();
                parcel2.writeNoException();
                if (activeNotifications != null) {
                    parcel2.writeInt(1);
                    activeNotifications.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 6:
                parcel.enforceInterface(DESCRIPTOR);
                Bundle bundleAreNotificationsEnabled = areNotificationsEnabled(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (bundleAreNotificationsEnabled != null) {
                    parcel2.writeInt(1);
                    bundleAreNotificationsEnabled.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 7:
                parcel.enforceInterface(DESCRIPTOR);
                Bundle smallIconBitmap = getSmallIconBitmap();
                parcel2.writeNoException();
                if (smallIconBitmap != null) {
                    parcel2.writeInt(1);
                    smallIconBitmap.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
