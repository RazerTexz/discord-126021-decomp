package b.i.c.o.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.firebase.dynamiclinks.internal.zzr;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final zzr createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            if (((char) i) != 2) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                strR = AnimatableValueParser.R(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzr(strR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i) {
        return new zzr[i];
    }
}
