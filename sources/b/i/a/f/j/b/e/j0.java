package b.i.a.f.j.b.e;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzcg;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements Parcelable$Creator<zzcg> {
    @Override // android.os.Parcelable$Creator
    public final zzcg createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        IBinder iBinderF1 = null;
        IBinder iBinderF2 = null;
        PendingIntent pendingIntent = null;
        String strR = null;
        String strR2 = null;
        ClientAppContext clientAppContext = null;
        int iG1 = 0;
        int iG2 = 0;
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
                    pendingIntent = (PendingIntent) b.c.a.a0.d.Q(parcel, i, PendingIntent.CREATOR);
                    break;
                case 5:
                    iG2 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 6:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 7:
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\b':
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case '\t':
                    clientAppContext = (ClientAppContext) b.c.a.a0.d.Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzcg(iG1, iBinderF1, iBinderF2, pendingIntent, iG2, strR, strR2, zE1, clientAppContext);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzcg[] newArray(int i) {
        return new zzcg[i];
    }
}
