package p007b.p225i.p226a.p288f.p313h.p328o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.o.h */
/* JADX INFO: loaded from: classes3.dex */
public final class C3961h implements InterfaceC3960g, IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f10493a;

    /* JADX INFO: renamed from: b */
    public final String f10494b = "com.google.android.gms.safetynet.internal.ISafetyNetService";

    public C3961h(IBinder iBinder) {
        this.f10493a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f10493a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p225i.p226a.p288f.p313h.p328o.InterfaceC3960g
    /* JADX INFO: renamed from: n0 */
    public final void mo5437n0(InterfaceC3958e interfaceC3958e, String str) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f10494b);
        int i = C3955b.f10492a;
        parcelObtain.writeStrongBinder(interfaceC3958e == 0 ? null : (BinderC3954a) interfaceC3958e);
        parcelObtain.writeString(str);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.f10493a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
