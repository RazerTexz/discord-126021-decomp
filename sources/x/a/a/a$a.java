package x.a.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: ICustomTabsCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a$a extends Binder implements a {
    private static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsCallback";
    public static final int TRANSACTION_extraCallback = 3;
    public static final int TRANSACTION_extraCallbackWithResult = 7;
    public static final int TRANSACTION_onMessageChannelReady = 4;
    public static final int TRANSACTION_onNavigationEvent = 2;
    public static final int TRANSACTION_onPostMessage = 5;
    public static final int TRANSACTION_onRelationshipValidationResult = 6;

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

    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1598968902) {
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
        switch (i) {
            case 2:
                parcel.enforceInterface(DESCRIPTOR);
                onNavigationEvent(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface(DESCRIPTOR);
                extraCallback(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface(DESCRIPTOR);
                onMessageChannelReady(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface(DESCRIPTOR);
                onPostMessage(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface(DESCRIPTOR);
                onRelationshipValidationResult(parcel.readInt(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface(DESCRIPTOR);
                Bundle bundleExtraCallbackWithResult = extraCallbackWithResult(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (bundleExtraCallbackWithResult != null) {
                    parcel2.writeInt(1);
                    bundleExtraCallbackWithResult.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
