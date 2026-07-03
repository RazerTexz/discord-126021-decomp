package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.l.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3577a implements IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f9839a;

    /* JADX INFO: renamed from: b */
    public final String f9840b;

    public C3577a(IBinder iBinder, String str) {
        this.f9839a = iBinder;
        this.f9840b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f9839a;
    }

    /* JADX INFO: renamed from: c */
    public final Parcel m4518c() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9840b);
        return parcelObtain;
    }

    /* JADX INFO: renamed from: g */
    public final Parcel m4519g(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f9839a.transact(i, parcel, parcelObtain, 0);
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

    /* JADX INFO: renamed from: i */
    public final void m4520i(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f9839a.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
