package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzj;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements Parcelable$Creator<zzj> {
    @Override // android.os.Parcelable$Creator
    public final zzj createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        int iG1 = 0;
        ClientAppContext clientAppContext = null;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            } else if (c == 2) {
                clientAppContext = (ClientAppContext) b.c.a.a0.d.Q(parcel, i, ClientAppContext.CREATOR);
            } else if (c != 3) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                iG2 = b.c.a.a0.d.G1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzj(iG1, clientAppContext, iG2);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzj[] newArray(int i) {
        return new zzj[i];
    }
}
