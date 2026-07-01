package b.i.a.f.h.n;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends e implements d {
    public b(IBinder iBinder) {
        super(iBinder);
    }

    @Override // b.i.a.f.h.n.d
    public final Bundle E(int i, String str, String str2, String str3) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeInt(3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        Parcel parcelG = g(4, parcelC);
        Bundle bundle = (Bundle) g.a(parcelG, Bundle.CREATOR);
        parcelG.recycle();
        return bundle;
    }

    @Override // b.i.a.f.h.n.d
    public final Bundle F(int i, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeInt(3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        parcelC.writeString(null);
        Parcel parcelG = g(3, parcelC);
        Bundle bundle = (Bundle) g.a(parcelG, Bundle.CREATOR);
        parcelG.recycle();
        return bundle;
    }

    @Override // b.i.a.f.h.n.d
    public final int N(int i, String str, String str2) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeInt(i);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        Parcel parcelG = g(1, parcelC);
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // b.i.a.f.h.n.d
    public final Bundle c0(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeInt(i);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        parcelC.writeString(null);
        int i2 = g.a;
        parcelC.writeInt(1);
        bundle.writeToParcel(parcelC, 0);
        Parcel parcelG = g(8, parcelC);
        Bundle bundle2 = (Bundle) g.a(parcelG, Bundle.CREATOR);
        parcelG.recycle();
        return bundle2;
    }

    @Override // b.i.a.f.h.n.d
    public final Bundle e0(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeInt(3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        int i2 = g.a;
        parcelC.writeInt(1);
        bundle.writeToParcel(parcelC, 0);
        Parcel parcelG = g(2, parcelC);
        Bundle bundle2 = (Bundle) g.a(parcelG, Bundle.CREATOR);
        parcelG.recycle();
        return bundle2;
    }

    @Override // b.i.a.f.h.n.d
    public final Bundle o(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeInt(10);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        int i2 = g.a;
        parcelC.writeInt(1);
        bundle.writeToParcel(parcelC, 0);
        parcelC.writeInt(1);
        bundle2.writeToParcel(parcelC, 0);
        Parcel parcelG = g(901, parcelC);
        Bundle bundle3 = (Bundle) g.a(parcelG, Bundle.CREATOR);
        parcelG.recycle();
        return bundle3;
    }

    @Override // b.i.a.f.h.n.d
    public final Bundle o0(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeInt(9);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        int i2 = g.a;
        parcelC.writeInt(1);
        bundle.writeToParcel(parcelC, 0);
        Parcel parcelG = g(11, parcelC);
        Bundle bundle2 = (Bundle) g.a(parcelG, Bundle.CREATOR);
        parcelG.recycle();
        return bundle2;
    }

    @Override // b.i.a.f.h.n.d
    public final int q(int i, String str, String str2) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeInt(3);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        Parcel parcelG = g(5, parcelC);
        int i2 = parcelG.readInt();
        parcelG.recycle();
        return i2;
    }

    @Override // b.i.a.f.h.n.d
    public final Bundle r(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeInt(9);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        int i2 = g.a;
        parcelC.writeInt(1);
        bundle.writeToParcel(parcelC, 0);
        Parcel parcelG = g(12, parcelC);
        Bundle bundle2 = (Bundle) g.a(parcelG, Bundle.CREATOR);
        parcelG.recycle();
        return bundle2;
    }
}
