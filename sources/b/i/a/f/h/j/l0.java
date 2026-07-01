package b.i.a.f.h.j;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements k0, IInterface {
    public final IBinder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1422b = "com.google.android.gms.analytics.internal.IAnalyticsService";

    public l0(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    @Override // b.i.a.f.h.j.k0
    public final void g0(Map map, long j, String str, List<?> list) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f1422b);
        parcelObtain.writeMap(map);
        parcelObtain.writeLong(j);
        parcelObtain.writeString(str);
        parcelObtain.writeTypedList(list);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
