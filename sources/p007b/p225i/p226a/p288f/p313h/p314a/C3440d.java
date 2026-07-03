package p007b.p225i.p226a.p288f.p313h.p314a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.a.d */
/* JADX INFO: loaded from: classes3.dex */
public final class C3440d implements InterfaceC3438b, IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f9623a;

    /* JADX INFO: renamed from: b */
    public final String f9624b = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

    public C3440d(IBinder iBinder) {
        this.f9623a = iBinder;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p314a.InterfaceC3438b
    /* JADX INFO: renamed from: D */
    public final boolean mo4391D(boolean z2) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9624b);
        int i = C3437a.f9621a;
        parcelObtain.writeInt(1);
        Parcel parcelM4392c = m4392c(2, parcelObtain);
        boolean z3 = parcelM4392c.readInt() != 0;
        parcelM4392c.recycle();
        return z3;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f9623a;
    }

    /* JADX INFO: renamed from: c */
    public final Parcel m4392c(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f9623a.transact(i, parcel, parcelObtain, 0);
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

    @Override // p007b.p225i.p226a.p288f.p313h.p314a.InterfaceC3438b
    public final String getId() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9624b);
        Parcel parcelM4392c = m4392c(1, parcelObtain);
        String string = parcelM4392c.readString();
        parcelM4392c.recycle();
        return string;
    }
}
