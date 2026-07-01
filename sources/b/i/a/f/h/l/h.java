package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.internal.measurement.zzae;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Parcelable.Creator<zzae> {
    @Override // android.os.Parcelable.Creator
    public final zzae createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        long jH1 = 0;
        long jH2 = 0;
        String strR = null;
        String strR2 = null;
        String strR3 = null;
        Bundle bundleM = null;
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    jH1 = AnimatableValueParser.H1(parcel, i);
                    break;
                case 2:
                    jH2 = AnimatableValueParser.H1(parcel, i);
                    break;
                case 3:
                    zE1 = AnimatableValueParser.E1(parcel, i);
                    break;
                case 4:
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case 5:
                    strR2 = AnimatableValueParser.R(parcel, i);
                    break;
                case 6:
                    strR3 = AnimatableValueParser.R(parcel, i);
                    break;
                case 7:
                    bundleM = AnimatableValueParser.M(parcel, i);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzae(jH1, jH2, zE1, strR, strR2, strR3, bundleM);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzae[] newArray(int i) {
        return new zzae[i];
    }
}
