package b.i.a.f.j.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzce;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements Parcelable$Creator<zzce> {
    @Override // android.os.Parcelable$Creator
    public final zzce createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        zzaf zzafVar = null;
        IBinder iBinderF1 = null;
        String strR = null;
        String strR2 = null;
        ClientAppContext clientAppContext = null;
        int iG1 = 0;
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 2:
                    zzafVar = (zzaf) b.c.a.a0.d.Q(parcel, i, zzaf.CREATOR);
                    break;
                case 3:
                    iBinderF1 = b.c.a.a0.d.F1(parcel, i);
                    break;
                case 4:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 5:
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 6:
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 7:
                    clientAppContext = (ClientAppContext) b.c.a.a0.d.Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzce(iG1, zzafVar, iBinderF1, strR, strR2, zE1, clientAppContext);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzce[] newArray(int i) {
        return new zzce[i];
    }
}
