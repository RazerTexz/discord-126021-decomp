package p007b.p225i.p226a.p288f.p313h.p316c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.c.c */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3454c implements IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f9635a;

    /* JADX INFO: renamed from: b */
    public final String f9636b;

    public C3454c(IBinder iBinder, String str) {
        this.f9635a = iBinder;
        this.f9636b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f9635a;
    }

    /* JADX INFO: renamed from: c */
    public final Parcel m4394c() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9636b);
        return parcelObtain;
    }

    /* JADX INFO: renamed from: g */
    public final void m4395g(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f9635a.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
