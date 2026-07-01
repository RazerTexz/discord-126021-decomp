package b.i.a.f.i.b;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class ia implements Parcelable$Creator<zzz> {
    @Override // android.os.Parcelable$Creator
    public final zzz createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        long jH1 = 0;
        long jH2 = 0;
        long jH3 = 0;
        String strR = null;
        String strR2 = null;
        zzku zzkuVar = null;
        String strR3 = null;
        zzaq zzaqVar = null;
        zzaq zzaqVar2 = null;
        zzaq zzaqVar3 = null;
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 2:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 3:
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 4:
                    zzkuVar = (zzku) b.c.a.a0.d.Q(parcel, i, zzku.CREATOR);
                    break;
                case 5:
                    jH1 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case 6:
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 7:
                    strR3 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\b':
                    zzaqVar = (zzaq) b.c.a.a0.d.Q(parcel, i, zzaq.CREATOR);
                    break;
                case '\t':
                    jH2 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case '\n':
                    zzaqVar2 = (zzaq) b.c.a.a0.d.Q(parcel, i, zzaq.CREATOR);
                    break;
                case 11:
                    jH3 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case '\f':
                    zzaqVar3 = (zzaq) b.c.a.a0.d.Q(parcel, i, zzaq.CREATOR);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzz(strR, strR2, zzkuVar, jH1, zE1, strR3, zzaqVar, jH2, zzaqVar2, jH3, zzaqVar3);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}
