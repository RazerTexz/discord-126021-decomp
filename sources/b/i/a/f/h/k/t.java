package b.i.a.f.h.k;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.internal.icing.zzu;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements Parcelable.Creator<zzu> {
    @Override // android.os.Parcelable.Creator
    public final zzu createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            if (((char) i) != 1) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                zE1 = AnimatableValueParser.E1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzu(zE1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzu[] newArray(int i) {
        return new zzu[i];
    }
}
