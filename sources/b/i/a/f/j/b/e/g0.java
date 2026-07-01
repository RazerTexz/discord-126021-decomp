package b.i.a.f.j.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzcb;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements Parcelable$Creator<zzcb> {
    @Override // android.os.Parcelable$Creator
    public final zzcb createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        IBinder iBinderF1 = null;
        IBinder iBinderF2 = null;
        String strR = null;
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
                    iBinderF1 = b.c.a.a0.d.F1(parcel, i);
                    break;
                case 3:
                    iBinderF2 = b.c.a.a0.d.F1(parcel, i);
                    break;
                case 4:
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 5:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 6:
                    clientAppContext = (ClientAppContext) b.c.a.a0.d.Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzcb(iG1, iBinderF1, iBinderF2, zE1, strR, clientAppContext);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzcb[] newArray(int i) {
        return new zzcb[i];
    }
}
