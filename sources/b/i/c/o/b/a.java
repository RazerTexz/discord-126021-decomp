package b.i.c.o.b;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Parcelable$Creator<DynamicLinkData> {
    @Override // android.os.Parcelable$Creator
    public final DynamicLinkData createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        String strR2 = null;
        Bundle bundleM = null;
        Uri uri = null;
        long jH1 = 0;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 2:
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 3:
                    iG1 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 4:
                    jH1 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case 5:
                    bundleM = b.c.a.a0.d.M(parcel, i);
                    break;
                case 6:
                    uri = (Uri) b.c.a.a0.d.Q(parcel, i, Uri.CREATOR);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new DynamicLinkData(strR, strR2, iG1, jH1, bundleM, uri);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ DynamicLinkData[] newArray(int i) {
        return new DynamicLinkData[i];
    }
}
