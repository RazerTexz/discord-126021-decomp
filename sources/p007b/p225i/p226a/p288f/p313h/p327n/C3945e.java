package p007b.p225i.p226a.p288f.p313h.p327n;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.n.e */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3945e implements IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f10481a;

    public C3945e(IBinder iBinder) {
        this.f10481a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f10481a;
    }

    /* JADX INFO: renamed from: c */
    public final Parcel m5427c() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        return parcelObtain;
    }

    /* JADX INFO: renamed from: g */
    public final Parcel m5428g(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f10481a.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }
}
