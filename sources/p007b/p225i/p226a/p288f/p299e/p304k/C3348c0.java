package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzn;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;
import p007b.p225i.p226a.p288f.p313h.p320g.C3481a;
import p007b.p225i.p226a.p288f.p313h.p320g.C3483c;

/* JADX INFO: renamed from: b.i.a.f.e.k.c0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3348c0 extends C3481a implements InterfaceC3352e0 {
    public C3348c0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3352e0
    /* JADX INFO: renamed from: H */
    public final zzq mo4149H(zzn zznVar) throws RemoteException {
        Parcel parcelM4408g = m4408g();
        int i = C3483c.f9650a;
        parcelM4408g.writeInt(1);
        zznVar.writeToParcel(parcelM4408g, 0);
        Parcel parcelM4407c = m4407c(6, parcelM4408g);
        zzq zzqVar = (zzq) C3483c.m4409a(parcelM4407c, zzq.CREATOR);
        parcelM4407c.recycle();
        return zzqVar;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3352e0
    /* JADX INFO: renamed from: V */
    public final boolean mo4150V(zzs zzsVar, InterfaceC3422a interfaceC3422a) throws RemoteException {
        Parcel parcelM4408g = m4408g();
        int i = C3483c.f9650a;
        parcelM4408g.writeInt(1);
        zzsVar.writeToParcel(parcelM4408g, 0);
        C3483c.m4410b(parcelM4408g, interfaceC3422a);
        Parcel parcelM4407c = m4407c(5, parcelM4408g);
        boolean z2 = parcelM4407c.readInt() != 0;
        parcelM4407c.recycle();
        return z2;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3352e0
    /* JADX INFO: renamed from: h */
    public final boolean mo4151h() throws RemoteException {
        Parcel parcelM4407c = m4407c(7, m4408g());
        int i = C3483c.f9650a;
        boolean z2 = parcelM4407c.readInt() != 0;
        parcelM4407c.recycle();
        return z2;
    }
}
