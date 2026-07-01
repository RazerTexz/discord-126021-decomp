package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.nearby.messages.internal.zza;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Parcelable$Creator<zza> {
    @Override // android.os.Parcelable$Creator
    public final zza createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        int iG1 = 0;
        int iG2 = 0;
        int iG3 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            } else if (c == 2) {
                iG2 = b.c.a.a0.d.G1(parcel, i);
            } else if (c != 3) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                iG3 = b.c.a.a0.d.G1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zza(iG1, iG2, iG3);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
