package p007b.p225i.p226a.p288f.p313h.p324k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzi;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.k.n */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3569n implements Parcelable.Creator<zzi> {
    @Override // android.os.Parcelable.Creator
    public final zzi createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        String strM468R2 = null;
        String strM468R3 = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 2) {
                strM468R2 = C1460d.m468R(parcel, i);
            } else if (c != 3) {
                C1460d.m510d2(parcel, i);
            } else {
                strM468R3 = C1460d.m468R(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzi(strM468R, strM468R2, strM468R3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi[] newArray(int i) {
        return new zzi[i];
    }
}
