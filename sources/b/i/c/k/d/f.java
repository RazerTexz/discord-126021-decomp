package b.i.c.k.d;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.firebase.appindexing.internal.zzc;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements Parcelable.Creator<zzc> {
    @Override // android.os.Parcelable.Creator
    public final zzc createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        String strR2 = null;
        byte[] bArrN = null;
        int iG1 = 0;
        boolean zE1 = false;
        boolean zE2 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 2:
                    zE1 = AnimatableValueParser.E1(parcel, i);
                    break;
                case 3:
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case 4:
                    strR2 = AnimatableValueParser.R(parcel, i);
                    break;
                case 5:
                    bArrN = AnimatableValueParser.N(parcel, i);
                    break;
                case 6:
                    zE2 = AnimatableValueParser.E1(parcel, i);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzc(iG1, zE1, strR, strR2, bArrN, zE2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i) {
        return new zzc[i];
    }
}
