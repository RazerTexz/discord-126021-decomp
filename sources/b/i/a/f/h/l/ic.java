package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ic extends s0 implements fc {
    public ic() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // b.i.a.f.h.l.s0
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((cc) this).f((Bundle) v.a(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
