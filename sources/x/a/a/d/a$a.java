package x.a.a.d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: ITrustedWebActivityCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a$a extends Binder implements a {
    private static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityCallback";
    public static final int TRANSACTION_onExtraCallback = 2;

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
        if (i != 2) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
        parcel.enforceInterface(DESCRIPTOR);
        onExtraCallback(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
        parcel2.writeNoException();
        return true;
    }
}
