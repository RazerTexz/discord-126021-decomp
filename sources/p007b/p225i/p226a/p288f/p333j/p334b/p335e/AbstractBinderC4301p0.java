package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.messages.internal.Update;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3925b;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3931h;
import p007b.p225i.p226a.p288f.p313h.p326m.C3932i;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.p0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC4301p0 extends BinderC3925b implements InterfaceC4299o0 {
    public AbstractBinderC4301p0() {
        super("com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p326m.BinderC3925b
    /* JADX INFO: renamed from: c */
    public final boolean mo5400c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1 || i == 2) {
        } else {
            if (i != 4) {
                return false;
            }
            ((BinderC3931h) this).f10458a.m4106a(new C3932i(parcel.createTypedArrayList(Update.CREATOR)));
        }
        return true;
    }
}
