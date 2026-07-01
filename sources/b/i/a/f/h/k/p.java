package b.i.a.f.h.k;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.icing.zzm;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements Parcelable$Creator<zzm> {
    @Override // android.os.Parcelable$Creator
    public final zzm createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        int iG1 = 0;
        Bundle bundleM = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            } else if (c != 2) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                bundleM = b.c.a.a0.d.M(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzm(iG1, bundleM);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzm[] newArray(int i) {
        return new zzm[i];
    }
}
