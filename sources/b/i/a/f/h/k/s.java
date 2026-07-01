package b.i.a.f.h.k;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.icing.zzm;
import com.google.android.gms.internal.icing.zzt;
import com.google.android.gms.internal.icing.zzu;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements Parcelable$Creator<zzt> {
    @Override // android.os.Parcelable$Creator
    public final zzt createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        String strR2 = null;
        String strR3 = null;
        zzm[] zzmVarArr = null;
        String strR4 = null;
        zzu zzuVar = null;
        boolean zE1 = false;
        int iG1 = 1;
        boolean zE2 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 11) {
                strR4 = b.c.a.a0.d.R(parcel, i);
            } else if (c != '\f') {
                switch (c) {
                    case 1:
                        strR = b.c.a.a0.d.R(parcel, i);
                        break;
                    case 2:
                        strR2 = b.c.a.a0.d.R(parcel, i);
                        break;
                    case 3:
                        zE1 = b.c.a.a0.d.E1(parcel, i);
                        break;
                    case 4:
                        iG1 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 5:
                        zE2 = b.c.a.a0.d.E1(parcel, i);
                        break;
                    case 6:
                        strR3 = b.c.a.a0.d.R(parcel, i);
                        break;
                    case 7:
                        zzmVarArr = (zzm[]) b.c.a.a0.d.U(parcel, i, zzm.CREATOR);
                        break;
                    default:
                        b.c.a.a0.d.d2(parcel, i);
                        break;
                }
            } else {
                zzuVar = (zzu) b.c.a.a0.d.Q(parcel, i, zzu.CREATOR);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzt(strR, strR2, zE1, iG1, zE2, strR3, zzmVarArr, strR4, zzuVar);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzt[] newArray(int i) {
        return new zzt[i];
    }
}
