package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.measurement.zzae;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Parcelable$Creator<zzae> {
    @Override // android.os.Parcelable$Creator
    public final zzae createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        long jH1 = 0;
        long jH2 = 0;
        String strR = null;
        String strR2 = null;
        String strR3 = null;
        Bundle bundleM = null;
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    jH1 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case 2:
                    jH2 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case 3:
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 4:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 5:
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 6:
                    strR3 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 7:
                    bundleM = b.c.a.a0.d.M(parcel, i);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzae(jH1, jH2, zE1, strR, strR2, strR3, bundleM);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzae[] newArray(int i) {
        return new zzae[i];
    }
}
