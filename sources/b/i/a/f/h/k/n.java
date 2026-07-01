package b.i.a.f.h.k;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.internal.icing.zzi;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements Parcelable.Creator<zzi> {
    @Override // android.os.Parcelable.Creator
    public final zzi createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        String strR2 = null;
        String strR3 = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 2) {
                strR2 = AnimatableValueParser.R(parcel, i);
            } else if (c != 3) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                strR3 = AnimatableValueParser.R(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzi(strR, strR2, strR3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi[] newArray(int i) {
        return new zzi[i];
    }
}
