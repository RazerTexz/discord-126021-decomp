package b.i.a.f.h.m;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.internal.nearby.zzgu;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Parcelable.Creator<zzgu> {
    @Override // android.os.Parcelable.Creator
    public final zzgu createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        int iG1 = 0;
        byte[] bArrN = null;
        int iG2 = 0;
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG2 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 2) {
                bArrN = AnimatableValueParser.N(parcel, i);
            } else if (c == 3) {
                zE1 = AnimatableValueParser.E1(parcel, i);
            } else if (c != 1000) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                iG1 = AnimatableValueParser.G1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzgu(iG1, iG2, bArrN, zE1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgu[] newArray(int i) {
        return new zzgu[i];
    }
}
