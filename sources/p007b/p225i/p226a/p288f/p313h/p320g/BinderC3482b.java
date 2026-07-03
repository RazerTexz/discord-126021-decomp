package p007b.p225i.p226a.p288f.p313h.p320g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.g.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class BinderC3482b extends Binder implements IInterface {
    public BinderC3482b(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo4121c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return mo4121c(i, parcel, parcel2, i2);
    }
}
