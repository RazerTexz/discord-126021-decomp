package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.l.e */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3633e extends C3577a implements InterfaceC3605c {
    public C3633e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3605c
    /* JADX INFO: renamed from: Z */
    public final void mo4572Z(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        C3859v.m5328c(parcelM4518c, bundle);
        parcelM4518c.writeLong(j);
        m4520i(1, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3605c
    /* JADX INFO: renamed from: a */
    public final int mo4573a() throws RemoteException {
        Parcel parcelM4519g = m4519g(2, m4518c());
        int i = parcelM4519g.readInt();
        parcelM4519g.recycle();
        return i;
    }
}
