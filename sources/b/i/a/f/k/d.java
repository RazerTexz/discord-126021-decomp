package b.i.a.f.k;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.zzd;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Parcelable.Creator<zzd> {
    @Override // android.os.Parcelable.Creator
    public final zzd createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        long jH1 = 0;
        HarmfulAppsData[] harmfulAppsDataArr = null;
        int iG1 = 0;
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                jH1 = AnimatableValueParser.H1(parcel, i);
            } else if (c == 3) {
                harmfulAppsDataArr = (HarmfulAppsData[]) AnimatableValueParser.U(parcel, i, HarmfulAppsData.CREATOR);
            } else if (c == 4) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c != 5) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                zE1 = AnimatableValueParser.E1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzd(jH1, harmfulAppsDataArr, iG1, zE1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd[] newArray(int i) {
        return new zzd[i];
    }
}
