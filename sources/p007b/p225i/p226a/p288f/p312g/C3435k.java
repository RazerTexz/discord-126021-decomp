package p007b.p225i.p226a.p288f.p312g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;
import p007b.p225i.p226a.p288f.p313h.p320g.C3481a;
import p007b.p225i.p226a.p288f.p313h.p320g.C3483c;

/* JADX INFO: renamed from: b.i.a.f.g.k */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3435k extends C3481a implements IInterface {
    public C3435k(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    /* JADX INFO: renamed from: i */
    public final InterfaceC3422a m4385i(InterfaceC3422a interfaceC3422a, String str, int i) throws RemoteException {
        Parcel parcelM4408g = m4408g();
        C3483c.m4410b(parcelM4408g, interfaceC3422a);
        parcelM4408g.writeString(str);
        parcelM4408g.writeInt(i);
        Parcel parcelM4407c = m4407c(2, parcelM4408g);
        InterfaceC3422a interfaceC3422aM4380g = InterfaceC3422a.a.m4380g(parcelM4407c.readStrongBinder());
        parcelM4407c.recycle();
        return interfaceC3422aM4380g;
    }

    /* JADX INFO: renamed from: t0 */
    public final InterfaceC3422a m4386t0(InterfaceC3422a interfaceC3422a, String str, int i) throws RemoteException {
        Parcel parcelM4408g = m4408g();
        C3483c.m4410b(parcelM4408g, interfaceC3422a);
        parcelM4408g.writeString(str);
        parcelM4408g.writeInt(i);
        Parcel parcelM4407c = m4407c(4, parcelM4408g);
        InterfaceC3422a interfaceC3422aM4380g = InterfaceC3422a.a.m4380g(parcelM4407c.readStrongBinder());
        parcelM4407c.recycle();
        return interfaceC3422aM4380g;
    }

    /* JADX INFO: renamed from: u0 */
    public final InterfaceC3422a m4387u0(InterfaceC3422a interfaceC3422a, String str, boolean z2, long j) throws RemoteException {
        Parcel parcelM4408g = m4408g();
        C3483c.m4410b(parcelM4408g, interfaceC3422a);
        parcelM4408g.writeString(str);
        parcelM4408g.writeInt(z2 ? 1 : 0);
        parcelM4408g.writeLong(j);
        Parcel parcelM4407c = m4407c(7, parcelM4408g);
        InterfaceC3422a interfaceC3422aM4380g = InterfaceC3422a.a.m4380g(parcelM4407c.readStrongBinder());
        parcelM4407c.recycle();
        return interfaceC3422aM4380g;
    }

    /* JADX INFO: renamed from: v0 */
    public final InterfaceC3422a m4388v0(InterfaceC3422a interfaceC3422a, String str, int i, InterfaceC3422a interfaceC3422a2) throws RemoteException {
        Parcel parcelM4408g = m4408g();
        C3483c.m4410b(parcelM4408g, interfaceC3422a);
        parcelM4408g.writeString(str);
        parcelM4408g.writeInt(i);
        C3483c.m4410b(parcelM4408g, interfaceC3422a2);
        Parcel parcelM4407c = m4407c(8, parcelM4408g);
        InterfaceC3422a interfaceC3422aM4380g = InterfaceC3422a.a.m4380g(parcelM4407c.readStrongBinder());
        parcelM4407c.recycle();
        return interfaceC3422aM4380g;
    }
}
