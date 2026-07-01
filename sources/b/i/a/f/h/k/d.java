package b.i.a.f.h.k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.firebase.appindexing.internal.zza;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements b, IInterface {
    public final IBinder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1431b = "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";

    public d(IBinder iBinder) {
        this.a = iBinder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.a.f.h.k.b
    public final void S(c cVar, zza[] zzaVarArr) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1431b);
        int i = i.a;
        parcelObtain.writeStrongBinder((a) cVar);
        parcelObtain.writeTypedArray(zzaVarArr, 0);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }
}
