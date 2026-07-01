package b.i.a.f.i.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.measurement.internal.zzku;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s9 implements Parcelable.Creator<zzku> {
    @Override // android.os.Parcelable.Creator
    public final zzku createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        Long lValueOf = null;
        Float fValueOf = null;
        String strR2 = null;
        String strR3 = null;
        Double dValueOf = null;
        long jH1 = 0;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 2:
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case 3:
                    jH1 = AnimatableValueParser.H1(parcel, i);
                    break;
                case 4:
                    int iM1 = AnimatableValueParser.M1(parcel, i);
                    if (iM1 != 0) {
                        AnimatableValueParser.z2(parcel, i, iM1, 8);
                        lValueOf = Long.valueOf(parcel.readLong());
                    } else {
                        lValueOf = null;
                    }
                    break;
                case 5:
                    int iM3 = AnimatableValueParser.M1(parcel, i);
                    if (iM3 != 0) {
                        AnimatableValueParser.z2(parcel, i, iM3, 4);
                        fValueOf = Float.valueOf(parcel.readFloat());
                    } else {
                        fValueOf = null;
                    }
                    break;
                case 6:
                    strR2 = AnimatableValueParser.R(parcel, i);
                    break;
                case 7:
                    strR3 = AnimatableValueParser.R(parcel, i);
                    break;
                case '\b':
                    int iM4 = AnimatableValueParser.M1(parcel, i);
                    if (iM4 != 0) {
                        AnimatableValueParser.z2(parcel, i, iM4, 8);
                        dValueOf = Double.valueOf(parcel.readDouble());
                    } else {
                        dValueOf = null;
                    }
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzku(iG1, strR, jH1, lValueOf, fValueOf, strR2, strR3, dValueOf);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzku[] newArray(int i) {
        return new zzku[i];
    }
}
