package p007b.p225i.p226a.p288f.p313h.p328o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.zzf;
import p007b.p225i.p226a.p288f.p313h.p328o.C3962i;

/* JADX INFO: renamed from: b.i.a.f.h.o.a */
/* JADX INFO: loaded from: classes3.dex */
public class BinderC3954a extends Binder implements IInterface {
    public BinderC3954a(String str) {
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
        AbstractBinderC3959f abstractBinderC3959f = (AbstractBinderC3959f) this;
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
            ((BinderC3964k) abstractBinderC3959f).f10499a.mo3989b(new C3962i.b((Status) C3955b.m5436a(parcel, Status.CREATOR), (zzf) C3955b.m5436a(parcel, zzf.CREATOR)));
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
