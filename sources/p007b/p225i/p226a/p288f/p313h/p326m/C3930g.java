package p007b.p225i.p226a.p288f.p313h.p326m;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.nearby.zzgu;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.m.g */
/* JADX INFO: loaded from: classes3.dex */
public final class C3930g implements Parcelable.Creator<zzgu> {
    @Override // android.os.Parcelable.Creator
    public final zzgu createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        int iM437G1 = 0;
        byte[] bArrM456N = null;
        int iM437G2 = 0;
        boolean zM431E1 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G2 = C1460d.m437G1(parcel, i);
            } else if (c == 2) {
                bArrM456N = C1460d.m456N(parcel, i);
            } else if (c == 3) {
                zM431E1 = C1460d.m431E1(parcel, i);
            } else if (c != 1000) {
                C1460d.m510d2(parcel, i);
            } else {
                iM437G1 = C1460d.m437G1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzgu(iM437G1, iM437G2, bArrM456N, zM431E1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgu[] newArray(int i) {
        return new zzgu[i];
    }
}
