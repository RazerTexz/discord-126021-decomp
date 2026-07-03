package p007b.p225i.p226a.p288f.p313h.p326m;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.m.b */
/* JADX INFO: loaded from: classes3.dex */
public class BinderC3925b extends Binder implements IInterface {
    public BinderC3925b(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo5400c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        throw null;
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
        return mo5400c(i, parcel, parcel2, i2);
    }
}
