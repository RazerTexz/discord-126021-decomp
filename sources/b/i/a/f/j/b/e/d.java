package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.nearby.messages.internal.zzad;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Parcelable$Creator<zzad> {
    @Override // android.os.Parcelable$Creator
    public final zzad createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        String strR2 = null;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strR = b.c.a.a0.d.R(parcel, i);
            } else if (c == 2) {
                strR2 = b.c.a.a0.d.R(parcel, i);
            } else if (c != 1000) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzad(iG1, strR, strR2);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzad[] newArray(int i) {
        return new zzad[i];
    }
}
