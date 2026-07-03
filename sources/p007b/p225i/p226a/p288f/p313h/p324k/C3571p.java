package p007b.p225i.p226a.p288f.p313h.p324k;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzm;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.k.p */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3571p implements Parcelable.Creator<zzm> {
    @Override // android.os.Parcelable.Creator
    public final zzm createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        int iM437G1 = 0;
        Bundle bundleM453M = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c != 2) {
                C1460d.m510d2(parcel, i);
            } else {
                bundleM453M = C1460d.m453M(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzm(iM437G1, bundleM453M);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm[] newArray(int i) {
        return new zzm[i];
    }
}
