package p007b.p225i.p226a.p288f.p299e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.r */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3413r implements Parcelable.Creator<Feature> {
    @Override // android.os.Parcelable.Creator
    public final Feature createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        int iM437G1 = 0;
        long jM440H1 = -1;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 2) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c != 3) {
                C1460d.m510d2(parcel, i);
            } else {
                jM440H1 = C1460d.m440H1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new Feature(strM468R, iM437G1, jM440H1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Feature[] newArray(int i) {
        return new Feature[i];
    }
}
