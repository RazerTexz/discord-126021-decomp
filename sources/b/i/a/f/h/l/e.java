package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends a implements c {
    public e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // b.i.a.f.h.l.c
    public final void Z(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        v.c(parcelC, bundle);
        parcelC.writeLong(j);
        i(1, parcelC);
    }

    @Override // b.i.a.f.h.l.c
    public final int a() throws RemoteException {
        Parcel parcelG = g(2, c());
        int i = parcelG.readInt();
        parcelG.recycle();
        return i;
    }
}
