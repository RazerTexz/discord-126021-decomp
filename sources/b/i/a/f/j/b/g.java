package b.i.a.f.j.b;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.nearby.zzgp;
import com.google.android.gms.internal.nearby.zzgu;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.internal.zzad;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Parcelable$Creator<MessageFilter> {
    @Override // android.os.Parcelable$Creator
    public final MessageFilter createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        ArrayList arrayListV = null;
        ArrayList arrayListV2 = null;
        ArrayList arrayListV3 = null;
        int iG1 = 0;
        boolean zE1 = false;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                arrayListV = b.c.a.a0.d.V(parcel, i, zzad.CREATOR);
            } else if (c == 2) {
                arrayListV2 = b.c.a.a0.d.V(parcel, i, zzgu.CREATOR);
            } else if (c == 3) {
                zE1 = b.c.a.a0.d.E1(parcel, i);
            } else if (c == 4) {
                arrayListV3 = b.c.a.a0.d.V(parcel, i, zzgp.CREATOR);
            } else if (c == 5) {
                iG2 = b.c.a.a0.d.G1(parcel, i);
            } else if (c != 1000) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new MessageFilter(iG1, arrayListV, arrayListV2, zE1, arrayListV3, iG2);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ MessageFilter[] newArray(int i) {
        return new MessageFilter[i];
    }
}
