package p007b.p225i.p226a.p288f.p313h.p324k;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: b.i.a.f.h.k.a */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public class BinderC3556a extends Binder implements IInterface {
    public BinderC3556a(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
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
        AbstractBinderC3561f abstractBinderC3561f = (AbstractBinderC3561f) this;
        if (i == 1) {
            ((BinderC3563h) abstractBinderC3561f).f9832a.mo3989b((T) ((Status) C3564i.m4517a(parcel, Status.CREATOR)));
        } else if (i == 2) {
        } else {
            if (i != 4) {
                return false;
            }
        }
        return true;
    }
}
