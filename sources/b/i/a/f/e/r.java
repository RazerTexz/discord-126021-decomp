package b.i.a.f.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements Parcelable.Creator<Feature> {
    @Override // android.os.Parcelable.Creator
    public final Feature createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        int iG1 = 0;
        long jH1 = -1;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 2) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c != 3) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                jH1 = AnimatableValueParser.H1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new Feature(strR, iG1, jH1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Feature[] newArray(int i) {
        return new Feature[i];
    }
}
