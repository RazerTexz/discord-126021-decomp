package p007b.p225i.p226a.p288f.p313h.p320g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.g.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3481a implements IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f9648a;

    /* JADX INFO: renamed from: b */
    public final String f9649b;

    public C3481a(IBinder iBinder, String str) {
        this.f9648a = iBinder;
        this.f9649b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9648a;
    }

    /* JADX INFO: renamed from: c */
    public final Parcel m4407c(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f9648a.transact(i, parcel, parcelObtain, 0);
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

    /* JADX INFO: renamed from: g */
    public final Parcel m4408g() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9649b);
        return parcelObtain;
    }
}
