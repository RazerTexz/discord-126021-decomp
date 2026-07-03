package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.l.d3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3623d3 extends C3577a implements InterfaceC3636e2 {
    public C3623d3(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3636e2
    /* JADX INFO: renamed from: f */
    public final Bundle mo4629f(Bundle bundle) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, bundle);
        Parcel parcelM4519g = m4519g(1, parcelM4518c);
        Bundle bundle2 = (Bundle) C3859v.m5326a(parcelM4519g, Bundle.CREATOR);
        parcelM4519g.recycle();
        return bundle2;
    }
}
