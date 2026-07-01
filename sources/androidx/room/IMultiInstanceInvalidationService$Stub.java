package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class IMultiInstanceInvalidationService$Stub extends Binder implements IMultiInstanceInvalidationService {
    private static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";
    public static final int TRANSACTION_broadcastInvalidation = 3;
    public static final int TRANSACTION_registerCallback = 1;
    public static final int TRANSACTION_unregisterCallback = 2;

    public IMultiInstanceInvalidationService$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IMultiInstanceInvalidationService asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMultiInstanceInvalidationService)) ? new IMultiInstanceInvalidationService$Stub$Proxy(iBinder) : (IMultiInstanceInvalidationService) iInterfaceQueryLocalInterface;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            int iRegisterCallback = registerCallback(IMultiInstanceInvalidationCallback$Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(iRegisterCallback);
            return true;
        }
        if (i == 2) {
            parcel.enforceInterface(DESCRIPTOR);
            unregisterCallback(IMultiInstanceInvalidationCallback$Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
        if (i == 3) {
            parcel.enforceInterface(DESCRIPTOR);
            broadcastInvalidation(parcel.readInt(), parcel.createStringArray());
            return true;
        }
        if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }
}
