package b.i.a.f.h.m;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.nearby.zzgs;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Parcelable$Creator<zzgs> {
    @Override // android.os.Parcelable$Creator
    public final zzgs createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        String strR2 = null;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 3) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c == 6) {
                strR2 = b.c.a.a0.d.R(parcel, i);
            } else if (c != 1000) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzgs(iG1, strR, strR2);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzgs[] newArray(int i) {
        return new zzgs[i];
    }
}
