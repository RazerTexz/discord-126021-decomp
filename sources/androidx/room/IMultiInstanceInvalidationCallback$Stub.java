package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class IMultiInstanceInvalidationCallback$Stub extends Binder implements IMultiInstanceInvalidationCallback {
    private static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationCallback";
    public static final int TRANSACTION_onInvalidation = 1;

    public IMultiInstanceInvalidationCallback$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IMultiInstanceInvalidationCallback asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationCallback)) ? new IMultiInstanceInvalidationCallback$Stub$Proxy(iBinder) : (IMultiInstanceInvalidationCallback) iInterfaceQueryLocalInterface;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            onInvalidation(parcel.createStringArray());
            return true;
        }
        if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }
}
