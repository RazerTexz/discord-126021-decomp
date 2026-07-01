package b.i.a.f.l.b;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.signin.internal.zak;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements Parcelable$Creator<zak> {
    @Override // android.os.Parcelable$Creator
    public final zak createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        int iG1 = 0;
        zas zasVar = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            } else if (c != 2) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                zasVar = (zas) b.c.a.a0.d.Q(parcel, i, zas.CREATOR);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zak(iG1, zasVar);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zak[] newArray(int i) {
        return new zak[i];
    }
}
