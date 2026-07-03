package p007b.p225i.p226a.p288f.p337l.p338b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zau;
import com.google.android.gms.signin.internal.zam;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.l.b.j */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4345j implements Parcelable.Creator<zam> {
    @Override // android.os.Parcelable.Creator
    public final zam createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        ConnectionResult connectionResult = null;
        zau zauVar = null;
        int iM437G1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c == 2) {
                connectionResult = (ConnectionResult) C1460d.m465Q(parcel, i, ConnectionResult.CREATOR);
            } else if (c != 3) {
                C1460d.m510d2(parcel, i);
            } else {
                zauVar = (zau) C1460d.m465Q(parcel, i, zau.CREATOR);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zam(iM437G1, connectionResult, zauVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zam[] newArray(int i) {
        return new zam[i];
    }
}
