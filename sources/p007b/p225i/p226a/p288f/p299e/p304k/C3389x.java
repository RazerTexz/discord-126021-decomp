package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zau;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.k.x */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3389x implements Parcelable.Creator<zau> {
    @Override // android.os.Parcelable.Creator
    public final zau createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        IBinder iBinderM434F1 = null;
        ConnectionResult connectionResult = null;
        int iM437G1 = 0;
        boolean zM431E1 = false;
        boolean zM431E2 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c == 2) {
                iBinderM434F1 = C1460d.m434F1(parcel, i);
            } else if (c == 3) {
                connectionResult = (ConnectionResult) C1460d.m465Q(parcel, i, ConnectionResult.CREATOR);
            } else if (c == 4) {
                zM431E1 = C1460d.m431E1(parcel, i);
            } else if (c != 5) {
                C1460d.m510d2(parcel, i);
            } else {
                zM431E2 = C1460d.m431E1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zau(iM437G1, iBinderM434F1, connectionResult, zM431E1, zM431E2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zau[] newArray(int i) {
        return new zau[i];
    }
}
