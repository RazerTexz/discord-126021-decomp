package b.i.a.f.e;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements Parcelable$Creator<Feature> {
    @Override // android.os.Parcelable$Creator
    public final Feature createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        int iG1 = 0;
        long jH1 = -1;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c == 2) {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            } else if (c != 3) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                jH1 = b.c.a.a0.d.H1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new Feature(strR, iG1, jH1);
    }

    @Override // android.os.Parcelable$Creator
    public final /* bridge */ /* synthetic */ Feature[] newArray(int i) {
        return new Feature[i];
    }
}
