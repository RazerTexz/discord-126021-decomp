package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3925b;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3936m;
import p007b.p225i.p226a.p288f.p313h.p326m.C3926c;
import p007b.p225i.p226a.p288f.p313h.p326m.C3937n;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.a1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC4270a1 extends BinderC3925b implements InterfaceC4321z0 {
    public AbstractBinderC4270a1() {
        super("com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p326m.BinderC3925b
    /* JADX INFO: renamed from: c */
    public final boolean mo5400c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        int i3 = C3926c.f10449a;
        ((BinderC3936m) this).f10463a.m4106a(new C3937n(parcel.readInt() != 0));
        return true;
    }
}
