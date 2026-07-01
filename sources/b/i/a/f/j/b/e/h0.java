package b.i.a.f.j.b.e;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements Parcelable$Creator<SubscribeRequest> {
    @Override // android.os.Parcelable$Creator
    public final SubscribeRequest createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        IBinder iBinderF1 = null;
        Strategy strategy = null;
        IBinder iBinderF2 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        String strR = null;
        String strR2 = null;
        byte[] bArrN = null;
        IBinder iBinderF3 = null;
        ClientAppContext clientAppContext = null;
        int iG1 = 0;
        int iG2 = 0;
        boolean zE1 = false;
        boolean zE2 = false;
        boolean zE3 = false;
        int iG3 = 0;
        int iG4 = 0;
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
                    strategy = (Strategy) b.c.a.a0.d.Q(parcel, i, Strategy.CREATOR);
                    break;
                case 4:
                    iBinderF2 = b.c.a.a0.d.F1(parcel, i);
                    break;
                case 5:
                    messageFilter = (MessageFilter) b.c.a.a0.d.Q(parcel, i, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) b.c.a.a0.d.Q(parcel, i, PendingIntent.CREATOR);
                    break;
                case 7:
                    iG2 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case '\b':
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\t':
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\n':
                    bArrN = b.c.a.a0.d.N(parcel, i);
                    break;
                case 11:
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case '\f':
                    iBinderF3 = b.c.a.a0.d.F1(parcel, i);
                    break;
                case '\r':
                    zE2 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 14:
                    clientAppContext = (ClientAppContext) b.c.a.a0.d.Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                case 15:
                    zE3 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 16:
                    iG3 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 17:
                    iG4 = b.c.a.a0.d.G1(parcel, i);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new SubscribeRequest(iG1, iBinderF1, strategy, iBinderF2, messageFilter, pendingIntent, iG2, strR, strR2, bArrN, zE1, iBinderF3, zE2, clientAppContext, zE3, iG3, iG4);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
