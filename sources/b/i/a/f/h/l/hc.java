package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class hc extends a implements fc {
    public hc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // b.i.a.f.h.l.fc
    public final void f(Bundle bundle) throws RemoteException {
        Parcel parcelC = c();
        v.c(parcelC, bundle);
        i(1, parcelC);
    }
}
