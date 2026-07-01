package b.i.a.f.h.m;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.internal.nearby.zzgp;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Parcelable.Creator<zzgp> {
    @Override // android.os.Parcelable.Creator
    public final zzgp createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = null;
        ParcelUuid parcelUuid3 = null;
        byte[] bArrN = null;
        byte[] bArrN2 = null;
        byte[] bArrN3 = null;
        byte[] bArrN4 = null;
        int iG1 = 0;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c != 1) {
                switch (c) {
                    case 4:
                        parcelUuid = (ParcelUuid) AnimatableValueParser.Q(parcel, i, ParcelUuid.CREATOR);
                        break;
                    case 5:
                        parcelUuid2 = (ParcelUuid) AnimatableValueParser.Q(parcel, i, ParcelUuid.CREATOR);
                        break;
                    case 6:
                        parcelUuid3 = (ParcelUuid) AnimatableValueParser.Q(parcel, i, ParcelUuid.CREATOR);
                        break;
                    case 7:
                        bArrN = AnimatableValueParser.N(parcel, i);
                        break;
                    case '\b':
                        bArrN2 = AnimatableValueParser.N(parcel, i);
                        break;
                    case '\t':
                        iG2 = AnimatableValueParser.G1(parcel, i);
                        break;
                    case '\n':
                        bArrN3 = AnimatableValueParser.N(parcel, i);
                        break;
                    case 11:
                        bArrN4 = AnimatableValueParser.N(parcel, i);
                        break;
                    default:
                        AnimatableValueParser.d2(parcel, i);
                        break;
                }
            } else {
                iG1 = AnimatableValueParser.G1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzgp(iG1, parcelUuid, parcelUuid2, parcelUuid3, bArrN, bArrN2, iG2, bArrN3, bArrN4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgp[] newArray(int i) {
        return new zzgp[i];
    }
}
