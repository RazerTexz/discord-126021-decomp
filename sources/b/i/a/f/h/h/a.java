package b.i.a.f.h.h;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import b.c.a.a0.d;
import b.i.c.o.b.g;
import b.i.c.o.b.k;
import com.google.android.gms.common.api.Status;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
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
        k kVar = (k) this;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            throw new UnsupportedOperationException();
        }
        Status status = (Status) b.a(parcel, Status.CREATOR);
        DynamicLinkData dynamicLinkData = (DynamicLinkData) b.a(parcel, DynamicLinkData.CREATOR);
        g gVar = (g) kVar;
        d.a2(status, dynamicLinkData == null ? null : new PendingDynamicLinkData(dynamicLinkData), gVar.a);
        if (dynamicLinkData != null) {
            Bundle bundle = dynamicLinkData.n;
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle.getBundle("scionData");
            if (bundle2 != null && bundle2.keySet() != null && gVar.f1759b != null) {
                for (String str : bundle2.keySet()) {
                    gVar.f1759b.a("fdl", str, bundle2.getBundle(str));
                }
            }
        }
        return true;
    }
}
