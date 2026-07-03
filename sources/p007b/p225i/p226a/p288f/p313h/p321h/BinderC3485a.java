package p007b.p225i.p226a.p288f.p313h.p321h;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p361c.p391o.p392b.AbstractBinderC4778k;
import p007b.p225i.p361c.p391o.p392b.BinderC4774g;

/* JADX INFO: renamed from: b.i.a.f.h.h.a */
/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public class BinderC3485a extends Binder implements IInterface {
    public BinderC3485a(String str) {
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
        AbstractBinderC4778k abstractBinderC4778k = (AbstractBinderC4778k) this;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            throw new UnsupportedOperationException();
        }
        Status status = (Status) C3486b.m4411a(parcel, Status.CREATOR);
        DynamicLinkData dynamicLinkData = (DynamicLinkData) C3486b.m4411a(parcel, DynamicLinkData.CREATOR);
        BinderC4774g binderC4774g = (BinderC4774g) abstractBinderC4778k;
        C1460d.m498a2(status, dynamicLinkData == null ? null : new PendingDynamicLinkData(dynamicLinkData), binderC4774g.f12811a);
        if (dynamicLinkData != null) {
            Bundle bundle = dynamicLinkData.f21426n;
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle.getBundle("scionData");
            if (bundle2 != null && bundle2.keySet() != null && binderC4774g.f12812b != null) {
                for (String str : bundle2.keySet()) {
                    binderC4774g.f12812b.mo6338a("fdl", str, bundle2.getBundle(str));
                }
            }
        }
        return true;
    }
}
