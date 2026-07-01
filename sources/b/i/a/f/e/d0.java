package b.i.a.f.e;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.zzq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements Parcelable$Creator<zzq> {
    @Override // android.os.Parcelable$Creator
    public final zzq createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        boolean zE1 = false;
        String strR = null;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                zE1 = b.c.a.a0.d.E1(parcel, i);
            } else if (c == 2) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c != 3) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzq(zE1, strR, iG1);
    }

    @Override // android.os.Parcelable$Creator
    public final /* bridge */ /* synthetic */ zzq[] newArray(int i) {
        return new zzq[i];
    }
}
