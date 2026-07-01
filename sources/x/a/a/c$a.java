package x.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IPostMessageService.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c$a extends Binder implements c {
    private static final String DESCRIPTOR = "android.support.customtabs.IPostMessageService";
    public static final int TRANSACTION_onMessageChannelReady = 2;
    public static final int TRANSACTION_onPostMessage = 3;

    public c$a() {
        attachInterface(this, DESCRIPTOR);
    }

    public static c asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new c$a$a(iBinder) : (c) iInterfaceQueryLocalInterface;
    }

    public static c getDefaultImpl() {
        return c$a$a.a;
    }

    public static boolean setDefaultImpl(c cVar) {
        if (c$a$a.a != null) {
            throw new IllegalStateException("setDefaultImpl() called twice");
        }
        if (cVar == null) {
            return false;
        }
        c$a$a.a = cVar;
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            parcel.enforceInterface(DESCRIPTOR);
            onMessageChannelReady(a$a.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
        if (i != 3) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
        parcel.enforceInterface(DESCRIPTOR);
        onPostMessage(a$a.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
        parcel2.writeNoException();
        return true;
    }
}
