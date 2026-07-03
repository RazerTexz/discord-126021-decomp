package p007b.p225i.p226a.p288f.p313h.p315b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.b.d */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3444d implements InterfaceC3445e, IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f9630a;

    /* JADX INFO: renamed from: b */
    public final String f9631b = "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";

    public C3444d(IBinder iBinder) {
        this.f9630a = iBinder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p225i.p226a.p288f.p313h.p315b.InterfaceC3445e
    /* JADX INFO: renamed from: Y */
    public final void mo4393Y(InterfaceC3447g interfaceC3447g) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9631b);
        int i = C3443c.f9629a;
        parcelObtain.writeStrongBinder((BinderC3441a) interfaceC3447g);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.f9630a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f9630a;
    }
}
