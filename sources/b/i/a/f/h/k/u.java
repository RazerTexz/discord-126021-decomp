package b.i.a.f.h.k;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.icing.zzh;
import com.google.android.gms.internal.icing.zzi;
import com.google.android.gms.internal.icing.zzw;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements Parcelable$Creator<zzw> {
    @Override // android.os.Parcelable$Creator
    public final zzw createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        zzi zziVar = null;
        String strR = null;
        zzh zzhVar = null;
        String strR2 = null;
        long jH1 = 0;
        int iG1 = 0;
        boolean zE1 = false;
        int iG2 = -1;
        int iG3 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    zziVar = (zzi) b.c.a.a0.d.Q(parcel, i, zzi.CREATOR);
                    break;
                case 2:
                    jH1 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case 3:
                    iG1 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 4:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 5:
                    zzhVar = (zzh) b.c.a.a0.d.Q(parcel, i, zzh.CREATOR);
                    break;
                case 6:
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 7:
                    iG2 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case '\b':
                    iG3 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case '\t':
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzw(zziVar, jH1, iG1, strR, zzhVar, zE1, iG2, iG3, strR2);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzw[] newArray(int i) {
        return new zzw[i];
    }
}
