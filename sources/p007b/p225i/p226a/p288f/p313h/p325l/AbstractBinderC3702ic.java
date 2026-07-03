package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.l.ic */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC3702ic extends BinderC3821s0 implements InterfaceC3660fc {
    public AbstractBinderC3702ic() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.BinderC3821s0
    /* JADX INFO: renamed from: c */
    public final boolean mo4565c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((BinderC3618cc) this).mo4619f((Bundle) C3859v.m5326a(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
