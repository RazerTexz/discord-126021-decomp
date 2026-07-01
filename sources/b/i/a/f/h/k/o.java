package b.i.a.f.h.k;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.internal.icing.zzk;
import com.google.android.gms.internal.icing.zzt;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements Parcelable.Creator<zzk> {
    @Override // android.os.Parcelable.Creator
    public final zzk createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        zzt zztVar = null;
        byte[] bArrN = null;
        int iG1 = -1;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 3) {
                zztVar = (zzt) AnimatableValueParser.Q(parcel, i, zzt.CREATOR);
            } else if (c == 4) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c != 5) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                bArrN = AnimatableValueParser.N(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzk(strR, zztVar, iG1, bArrN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i) {
        return new zzk[i];
    }
}
