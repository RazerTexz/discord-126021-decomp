package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;
import p007b.p225i.p226a.p288f.p313h.p320g.C3481a;

/* JADX INFO: renamed from: b.i.a.f.e.k.x0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3390x0 extends C3481a implements InterfaceC3394z0 {
    public C3390x0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3394z0
    /* JADX INFO: renamed from: d */
    public final InterfaceC3422a mo4177d() throws RemoteException {
        Parcel parcelM4407c = m4407c(1, m4408g());
        InterfaceC3422a interfaceC3422aM4380g = InterfaceC3422a.a.m4380g(parcelM4407c.readStrongBinder());
        parcelM4407c.recycle();
        return interfaceC3422aM4380g;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3394z0
    /* JADX INFO: renamed from: e */
    public final int mo4178e() throws RemoteException {
        Parcel parcelM4407c = m4407c(2, m4408g());
        int i = parcelM4407c.readInt();
        parcelM4407c.recycle();
        return i;
    }
}
