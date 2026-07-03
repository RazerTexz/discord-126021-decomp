package p007b.p225i.p226a.p288f.p313h.p315b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.b.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public class BinderC3441a extends Binder implements IInterface {
    public BinderC3441a(String str) {
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
        AbstractBinderC3446f abstractBinderC3446f = (AbstractBinderC3446f) this;
        if (i != 1) {
            return false;
        }
        Parcelable.Creator<Status> creator = Status.CREATOR;
        int i3 = C3443c.f9629a;
        C1460d.m498a2(parcel.readInt() == 0 ? null : creator.createFromParcel(parcel), null, ((BinderC3451k) abstractBinderC3446f).f9633a);
        return true;
    }
}
