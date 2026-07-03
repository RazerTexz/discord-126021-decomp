package p007b.p225i.p226a.p288f.p313h.p326m;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.m.a */
/* JADX INFO: loaded from: classes3.dex */
public class C3924a implements IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f10447a;

    /* JADX INFO: renamed from: b */
    public final String f10448b;

    public C3924a(IBinder iBinder, String str) {
        this.f10447a = iBinder;
        this.f10448b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f10447a;
    }

    /* JADX INFO: renamed from: c */
    public final Parcel m5398c() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f10448b);
        return parcelObtain;
    }

    /* JADX INFO: renamed from: g */
    public final void m5399g(int i, Parcel parcel) throws RemoteException {
        try {
            this.f10447a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
