package b.i.a.f.i.b;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements Parcelable$Creator<zzaq> {
    @Override // android.os.Parcelable$Creator
    public final zzaq createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        zzap zzapVar = null;
        String strR2 = null;
        long jH1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c == 3) {
                zzapVar = (zzap) b.c.a.a0.d.Q(parcel, i, zzap.CREATOR);
            } else if (c == 4) {
                strR2 = b.c.a.a0.d.R(parcel, i);
            } else if (c != 5) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                jH1 = b.c.a.a0.d.H1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzaq(strR, zzapVar, strR2, jH1);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzaq[] newArray(int i) {
        return new zzaq[i];
    }
}
