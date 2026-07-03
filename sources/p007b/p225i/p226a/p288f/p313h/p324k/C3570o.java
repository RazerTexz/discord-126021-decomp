package p007b.p225i.p226a.p288f.p313h.p324k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzk;
import com.google.android.gms.internal.icing.zzt;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.k.o */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3570o implements Parcelable.Creator<zzk> {
    @Override // android.os.Parcelable.Creator
    public final zzk createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        zzt zztVar = null;
        byte[] bArrM456N = null;
        int iM437G1 = -1;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 3) {
                zztVar = (zzt) C1460d.m465Q(parcel, i, zzt.CREATOR);
            } else if (c == 4) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c != 5) {
                C1460d.m510d2(parcel, i);
            } else {
                bArrM456N = C1460d.m456N(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzk(strM468R, zztVar, iM437G1, bArrM456N);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i) {
        return new zzk[i];
    }
}
