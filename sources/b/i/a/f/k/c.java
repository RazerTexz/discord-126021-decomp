package b.i.a.f.k;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.safetynet.HarmfulAppsData;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Parcelable$Creator<HarmfulAppsData> {
    @Override // android.os.Parcelable$Creator
    public final HarmfulAppsData createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        byte[] bArrN = null;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c == 3) {
                bArrN = b.c.a.a0.d.N(parcel, i);
            } else if (c != 4) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new HarmfulAppsData(strR, bArrN, iG1);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ HarmfulAppsData[] newArray(int i) {
        return new HarmfulAppsData[i];
    }
}
