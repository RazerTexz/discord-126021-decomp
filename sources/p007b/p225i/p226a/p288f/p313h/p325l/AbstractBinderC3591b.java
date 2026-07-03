package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;

/* JADX INFO: renamed from: b.i.a.f.h.l.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC3591b extends BinderC3821s0 implements InterfaceC3605c {
    public AbstractBinderC3591b() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.BinderC3821s0
    /* JADX INFO: renamed from: c */
    public final boolean mo4565c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            ((C3661g.c) this).mo4572Z(parcel.readString(), parcel.readString(), (Bundle) C3859v.m5326a(parcel, Bundle.CREATOR), parcel.readLong());
            parcel2.writeNoException();
        } else {
            if (i != 2) {
                return false;
            }
            int iMo4573a = ((C3661g.c) this).mo4573a();
            parcel2.writeNoException();
            parcel2.writeInt(iMo4573a);
        }
        return true;
    }
}
