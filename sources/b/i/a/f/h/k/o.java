package b.i.a.f.h.k;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.icing.zzk;
import com.google.android.gms.internal.icing.zzt;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements Parcelable$Creator<zzk> {
    @Override // android.os.Parcelable$Creator
    public final zzk createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        zzt zztVar = null;
        byte[] bArrN = null;
        int iG1 = -1;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c == 3) {
                zztVar = (zzt) b.c.a.a0.d.Q(parcel, i, zzt.CREATOR);
            } else if (c == 4) {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            } else if (c != 5) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                bArrN = b.c.a.a0.d.N(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzk(strR, zztVar, iG1, bArrN);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzk[] newArray(int i) {
        return new zzk[i];
    }
}
