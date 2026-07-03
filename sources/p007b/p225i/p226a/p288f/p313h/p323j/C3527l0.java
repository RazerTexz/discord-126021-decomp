package p007b.p225i.p226a.p288f.p313h.p323j;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.f.h.j.l0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3527l0 implements InterfaceC3525k0, IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f9757a;

    /* JADX INFO: renamed from: b */
    public final String f9758b = "com.google.android.gms.analytics.internal.IAnalyticsService";

    public C3527l0(IBinder iBinder) {
        this.f9757a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f9757a;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3525k0
    /* JADX INFO: renamed from: g0 */
    public final void mo4463g0(Map map, long j, String str, List<?> list) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9758b);
        parcelObtain.writeMap(map);
        parcelObtain.writeLong(j);
        parcelObtain.writeString(str);
        parcelObtain.writeTypedList(list);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.f9757a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
