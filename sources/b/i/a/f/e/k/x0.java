package b.i.a.f.e.k;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import b.i.a.f.f.a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class x0 extends b.i.a.f.h.g.a implements z0 {
    public x0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // b.i.a.f.e.k.z0
    public final b.i.a.f.f.a d() throws RemoteException {
        Parcel parcelC = c(1, g());
        b.i.a.f.f.a aVarG = a.AbstractBinderC0040a.g(parcelC.readStrongBinder());
        parcelC.recycle();
        return aVarG;
    }

    @Override // b.i.a.f.e.k.z0
    public final int e() throws RemoteException {
        Parcel parcelC = c(2, g());
        int i = parcelC.readInt();
        parcelC.recycle();
        return i;
    }
}
