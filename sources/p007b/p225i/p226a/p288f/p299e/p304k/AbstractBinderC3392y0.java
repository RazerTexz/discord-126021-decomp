package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.Parcel;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p299e.AbstractBinderC3419x;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;
import p007b.p225i.p226a.p288f.p313h.p320g.BinderC3482b;
import p007b.p225i.p226a.p288f.p313h.p320g.C3483c;

/* JADX INFO: renamed from: b.i.a.f.e.k.y0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC3392y0 extends BinderC3482b implements InterfaceC3394z0 {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f9573a = 0;

    public AbstractBinderC3392y0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p320g.BinderC3482b
    /* JADX INFO: renamed from: c */
    public final boolean mo4121c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            InterfaceC3422a interfaceC3422aMo4177d = ((AbstractBinderC3419x) this).mo4177d();
            parcel2.writeNoException();
            C3483c.m4410b(parcel2, interfaceC3422aMo4177d);
        } else {
            if (i != 2) {
                return false;
            }
            int i3 = ((AbstractBinderC3419x) this).f9611b;
            parcel2.writeNoException();
            parcel2.writeInt(i3);
        }
        return true;
    }
}
