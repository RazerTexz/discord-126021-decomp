package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.l.hc */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3688hc extends C3577a implements InterfaceC3660fc {
    public C3688hc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc
    /* JADX INFO: renamed from: f */
    public final void mo4619f(Bundle bundle) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, bundle);
        m4520i(1, parcelM4518c);
    }
}
