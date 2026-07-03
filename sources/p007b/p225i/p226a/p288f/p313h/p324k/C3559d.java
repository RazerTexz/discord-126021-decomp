package p007b.p225i.p226a.p288f.p313h.p324k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.firebase.appindexing.internal.zza;

/* JADX INFO: renamed from: b.i.a.f.h.k.d */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3559d implements InterfaceC3557b, IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f9830a;

    /* JADX INFO: renamed from: b */
    public final String f9831b = "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";

    public C3559d(IBinder iBinder) {
        this.f9830a = iBinder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p225i.p226a.p288f.p313h.p324k.InterfaceC3557b
    /* JADX INFO: renamed from: S */
    public final void mo4516S(InterfaceC3558c interfaceC3558c, zza[] zzaVarArr) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9831b);
        int i = C3564i.f9833a;
        parcelObtain.writeStrongBinder((BinderC3556a) interfaceC3558c);
        parcelObtain.writeTypedArray(zzaVarArr, 0);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.f9830a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f9830a;
    }
}
