package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d3 extends a implements e2 {
    public d3(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // b.i.a.f.h.l.e2
    public final Bundle f(Bundle bundle) throws RemoteException {
        Parcel parcelC = c();
        v.c(parcelC, bundle);
        Parcel parcelG = g(1, parcelC);
        Bundle bundle2 = (Bundle) v.a(parcelG, Bundle.CREATOR);
        parcelG.recycle();
        return bundle2;
    }
}
