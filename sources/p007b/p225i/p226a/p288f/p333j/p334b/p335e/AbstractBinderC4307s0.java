package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3925b;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3933j;
import p007b.p225i.p226a.p288f.p313h.p326m.C3926c;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.s0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC4307s0 extends BinderC3925b implements InterfaceC4305r0 {
    public AbstractBinderC4307s0() {
        super("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p326m.BinderC3925b
    /* JADX INFO: renamed from: c */
    public final boolean mo5400c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((BinderC3933j) this).m5406g((Status) C3926c.m5401a(parcel, Status.CREATOR));
        return true;
    }
}
