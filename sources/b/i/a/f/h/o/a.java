package b.i.a.f.h.o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.zzf;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Binder implements IInterface {
    public a(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean zOnTransact;
        if (i > 16777215) {
            zOnTransact = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            zOnTransact = false;
        }
        if (zOnTransact) {
            return true;
        }
        f fVar = (f) this;
        if (i == 1) {
            throw new UnsupportedOperationException();
        }
        if (i == 2) {
            parcel.readString();
            throw new UnsupportedOperationException();
        }
        if (i == 3) {
            throw new UnsupportedOperationException();
        }
        if (i == 4) {
            parcel.readInt();
            throw new UnsupportedOperationException();
        }
        if (i == 6) {
            ((k) fVar).a.g(new i$b((Status) b.a(parcel, Status.CREATOR), (zzf) b.a(parcel, zzf.CREATOR)));
            return true;
        }
        if (i == 8) {
            throw new UnsupportedOperationException();
        }
        if (i == 15) {
            throw new UnsupportedOperationException();
        }
        if (i == 10) {
            parcel.readInt();
            throw new UnsupportedOperationException();
        }
        if (i != 11) {
            return false;
        }
        throw new UnsupportedOperationException();
    }
}
