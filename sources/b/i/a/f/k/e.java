package b.i.a.f.k;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.safetynet.zzf;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Parcelable.Creator<zzf> {
    @Override // android.os.Parcelable.Creator
    public final zzf createFromParcel(Parcel parcel) {
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
        return new zzf(strR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzf[] newArray(int i) {
        return new zzf[i];
    }
}
