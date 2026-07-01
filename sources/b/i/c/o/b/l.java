package b.i.c.o.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements j, IInterface {
    public final IBinder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1760b = "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";

    public l(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.c.o.b.j
    public final void b0(h hVar, String str) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1760b);
        int i = b.i.a.f.h.h.b.a;
        parcelObtain.writeStrongBinder((b.i.a.f.h.h.a) hVar);
        parcelObtain.writeString(str);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
