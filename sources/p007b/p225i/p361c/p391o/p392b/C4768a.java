package p007b.p225i.p361c.p391o.p392b;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.c.o.b.a */
/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4768a implements Parcelable.Creator<DynamicLinkData> {
    @Override // android.os.Parcelable.Creator
    public final DynamicLinkData createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        String strM468R2 = null;
        Bundle bundleM453M = null;
        Uri uri = null;
        long jM440H1 = 0;
        int iM437G1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case 2:
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
                case 3:
                    iM437G1 = C1460d.m437G1(parcel, i);
                    break;
                case 4:
                    jM440H1 = C1460d.m440H1(parcel, i);
                    break;
                case 5:
                    bundleM453M = C1460d.m453M(parcel, i);
                    break;
                case 6:
                    uri = (Uri) C1460d.m465Q(parcel, i, Uri.CREATOR);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new DynamicLinkData(strM468R, strM468R2, iM437G1, jM440H1, bundleM453M, uri);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DynamicLinkData[] newArray(int i) {
        return new DynamicLinkData[i];
    }
}
