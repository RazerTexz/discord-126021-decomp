package b.i.a.f.h.o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements g, IInterface {
    public final IBinder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1511b = "com.google.android.gms.safetynet.internal.ISafetyNetService";

    public h(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.a.f.h.o.g
    public final void n0(e eVar, String str) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1511b);
        int i = b.a;
        parcelObtain.writeStrongBinder(eVar == 0 ? null : (a) eVar);
        parcelObtain.writeString(str);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
