package p007b.p225i.p226a.p288f.p313h.p327n;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.h.n.b */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3942b extends C3945e implements InterfaceC3944d {
    public C3942b(IBinder iBinder) {
        super(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d
    /* JADX INFO: renamed from: E */
    public final Bundle mo5418E(int i, String str, String str2, String str3) throws RemoteException {
        Parcel parcelM5427c = m5427c();
        parcelM5427c.writeInt(3);
        parcelM5427c.writeString(str);
        parcelM5427c.writeString(str2);
        parcelM5427c.writeString(str3);
        Parcel parcelM5428g = m5428g(4, parcelM5427c);
        Bundle bundle = (Bundle) C3947g.m5429a(parcelM5428g, Bundle.CREATOR);
        parcelM5428g.recycle();
        return bundle;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d
    /* JADX INFO: renamed from: F */
    public final Bundle mo5419F(int i, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel parcelM5427c = m5427c();
        parcelM5427c.writeInt(3);
        parcelM5427c.writeString(str);
        parcelM5427c.writeString(str2);
        parcelM5427c.writeString(str3);
        parcelM5427c.writeString(null);
        Parcel parcelM5428g = m5428g(3, parcelM5427c);
        Bundle bundle = (Bundle) C3947g.m5429a(parcelM5428g, Bundle.CREATOR);
        parcelM5428g.recycle();
        return bundle;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d
    /* JADX INFO: renamed from: N */
    public final int mo5420N(int i, String str, String str2) throws RemoteException {
        Parcel parcelM5427c = m5427c();
        parcelM5427c.writeInt(i);
        parcelM5427c.writeString(str);
        parcelM5427c.writeString(str2);
        Parcel parcelM5428g = m5428g(1, parcelM5427c);
        int i2 = parcelM5428g.readInt();
        parcelM5428g.recycle();
        return i2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d
    /* JADX INFO: renamed from: c0 */
    public final Bundle mo5421c0(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel parcelM5427c = m5427c();
        parcelM5427c.writeInt(i);
        parcelM5427c.writeString(str);
        parcelM5427c.writeString(str2);
        parcelM5427c.writeString(str3);
        parcelM5427c.writeString(null);
        int i2 = C3947g.f10482a;
        parcelM5427c.writeInt(1);
        bundle.writeToParcel(parcelM5427c, 0);
        Parcel parcelM5428g = m5428g(8, parcelM5427c);
        Bundle bundle2 = (Bundle) C3947g.m5429a(parcelM5428g, Bundle.CREATOR);
        parcelM5428g.recycle();
        return bundle2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d
    /* JADX INFO: renamed from: e0 */
    public final Bundle mo5422e0(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelM5427c = m5427c();
        parcelM5427c.writeInt(3);
        parcelM5427c.writeString(str);
        parcelM5427c.writeString(str2);
        int i2 = C3947g.f10482a;
        parcelM5427c.writeInt(1);
        bundle.writeToParcel(parcelM5427c, 0);
        Parcel parcelM5428g = m5428g(2, parcelM5427c);
        Bundle bundle2 = (Bundle) C3947g.m5429a(parcelM5428g, Bundle.CREATOR);
        parcelM5428g.recycle();
        return bundle2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d
    /* JADX INFO: renamed from: o */
    public final Bundle mo5423o(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel parcelM5427c = m5427c();
        parcelM5427c.writeInt(10);
        parcelM5427c.writeString(str);
        parcelM5427c.writeString(str2);
        int i2 = C3947g.f10482a;
        parcelM5427c.writeInt(1);
        bundle.writeToParcel(parcelM5427c, 0);
        parcelM5427c.writeInt(1);
        bundle2.writeToParcel(parcelM5427c, 0);
        Parcel parcelM5428g = m5428g(901, parcelM5427c);
        Bundle bundle3 = (Bundle) C3947g.m5429a(parcelM5428g, Bundle.CREATOR);
        parcelM5428g.recycle();
        return bundle3;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d
    /* JADX INFO: renamed from: o0 */
    public final Bundle mo5424o0(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel parcelM5427c = m5427c();
        parcelM5427c.writeInt(9);
        parcelM5427c.writeString(str);
        parcelM5427c.writeString(str2);
        parcelM5427c.writeString(str3);
        int i2 = C3947g.f10482a;
        parcelM5427c.writeInt(1);
        bundle.writeToParcel(parcelM5427c, 0);
        Parcel parcelM5428g = m5428g(11, parcelM5427c);
        Bundle bundle2 = (Bundle) C3947g.m5429a(parcelM5428g, Bundle.CREATOR);
        parcelM5428g.recycle();
        return bundle2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d
    /* JADX INFO: renamed from: q */
    public final int mo5425q(int i, String str, String str2) throws RemoteException {
        Parcel parcelM5427c = m5427c();
        parcelM5427c.writeInt(3);
        parcelM5427c.writeString(str);
        parcelM5427c.writeString(str2);
        Parcel parcelM5428g = m5428g(5, parcelM5427c);
        int i2 = parcelM5428g.readInt();
        parcelM5428g.recycle();
        return i2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d
    /* JADX INFO: renamed from: r */
    public final Bundle mo5426r(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelM5427c = m5427c();
        parcelM5427c.writeInt(9);
        parcelM5427c.writeString(str);
        parcelM5427c.writeString(str2);
        int i2 = C3947g.f10482a;
        parcelM5427c.writeInt(1);
        bundle.writeToParcel(parcelM5427c, 0);
        Parcel parcelM5428g = m5428g(12, parcelM5427c);
        Bundle bundle2 = (Bundle) C3947g.m5429a(parcelM5428g, Bundle.CREATOR);
        parcelM5428g.recycle();
        return bundle2;
    }
}
