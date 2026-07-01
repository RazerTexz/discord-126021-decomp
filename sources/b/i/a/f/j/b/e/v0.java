package b.i.a.f.j.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;
import com.google.android.gms.nearby.messages.internal.zzbz;
import com.google.android.gms.nearby.messages.internal.zzcb;
import com.google.android.gms.nearby.messages.internal.zzce;
import com.google.android.gms.nearby.messages.internal.zzcg;
import com.google.android.gms.nearby.messages.internal.zzj;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 extends b.i.a.f.h.m.a implements u0 {
    public v0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    @Override // b.i.a.f.j.b.e.u0
    public final void C(SubscribeRequest subscribeRequest) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.m.c.b(parcelC, subscribeRequest);
        g(3, parcelC);
    }

    @Override // b.i.a.f.j.b.e.u0
    public final void P(zzce zzceVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.m.c.b(parcelC, zzceVar);
        g(2, parcelC);
    }

    @Override // b.i.a.f.j.b.e.u0
    public final void i0(zzj zzjVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.m.c.b(parcelC, zzjVar);
        g(9, parcelC);
    }

    @Override // b.i.a.f.j.b.e.u0
    public final void j0(zzcg zzcgVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.m.c.b(parcelC, zzcgVar);
        g(4, parcelC);
    }

    @Override // b.i.a.f.j.b.e.u0
    public final void n(zzbz zzbzVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.m.c.b(parcelC, zzbzVar);
        g(1, parcelC);
    }

    @Override // b.i.a.f.j.b.e.u0
    public final void s(zzcb zzcbVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.m.c.b(parcelC, zzcbVar);
        g(8, parcelC);
    }
}
