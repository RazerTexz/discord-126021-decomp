package p007b.p225i.p226a.p288f.p336k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.safetynet.HarmfulAppsData;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.k.c */
/* JADX INFO: loaded from: classes3.dex */
public final class C4329c implements Parcelable.Creator<HarmfulAppsData> {
    @Override // android.os.Parcelable.Creator
    public final HarmfulAppsData createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        byte[] bArrM456N = null;
        int iM437G1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 3) {
                bArrM456N = C1460d.m456N(parcel, i);
            } else if (c != 4) {
                C1460d.m510d2(parcel, i);
            } else {
                iM437G1 = C1460d.m437G1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new HarmfulAppsData(strM468R, bArrM456N, iM437G1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HarmfulAppsData[] newArray(int i) {
        return new HarmfulAppsData[i];
    }
}
