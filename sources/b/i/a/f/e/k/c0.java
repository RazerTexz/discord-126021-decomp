package b.i.a.f.e.k;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzn;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends b.i.a.f.h.g.a implements e0 {
    public c0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // b.i.a.f.e.k.e0
    public final zzq H(zzn zznVar) throws RemoteException {
        Parcel parcelG = g();
        int i = b.i.a.f.h.g.c.a;
        parcelG.writeInt(1);
        zznVar.writeToParcel(parcelG, 0);
        Parcel parcelC = c(6, parcelG);
        zzq zzqVar = (zzq) b.i.a.f.h.g.c.a(parcelC, zzq.CREATOR);
        parcelC.recycle();
        return zzqVar;
    }

    @Override // b.i.a.f.e.k.e0
    public final boolean V(zzs zzsVar, b.i.a.f.f.a aVar) throws RemoteException {
        Parcel parcelG = g();
        int i = b.i.a.f.h.g.c.a;
        parcelG.writeInt(1);
        zzsVar.writeToParcel(parcelG, 0);
        b.i.a.f.h.g.c.b(parcelG, aVar);
        Parcel parcelC = c(5, parcelG);
        boolean z2 = parcelC.readInt() != 0;
        parcelC.recycle();
        return z2;
    }

    @Override // b.i.a.f.e.k.e0
    public final boolean h() throws RemoteException {
        Parcel parcelC = c(7, g());
        int i = b.i.a.f.h.g.c.a;
        boolean z2 = parcelC.readInt() != 0;
        parcelC.recycle();
        return z2;
    }
}
