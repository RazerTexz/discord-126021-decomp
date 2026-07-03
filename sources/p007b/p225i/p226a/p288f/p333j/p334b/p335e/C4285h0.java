package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.h0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4285h0 implements Parcelable.Creator<SubscribeRequest> {
    @Override // android.os.Parcelable.Creator
    public final SubscribeRequest createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        IBinder iBinderM434F1 = null;
        Strategy strategy = null;
        IBinder iBinderM434F2 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        String strM468R = null;
        String strM468R2 = null;
        byte[] bArrM456N = null;
        IBinder iBinderM434F3 = null;
        ClientAppContext clientAppContext = null;
        int iM437G1 = 0;
        int iM437G2 = 0;
        boolean zM431E1 = false;
        boolean zM431E2 = false;
        boolean zM431E3 = false;
        int iM437G3 = 0;
        int iM437G4 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iM437G1 = C1460d.m437G1(parcel, i);
                    break;
                case 2:
                    iBinderM434F1 = C1460d.m434F1(parcel, i);
                    break;
                case 3:
                    strategy = (Strategy) C1460d.m465Q(parcel, i, Strategy.CREATOR);
                    break;
                case 4:
                    iBinderM434F2 = C1460d.m434F1(parcel, i);
                    break;
                case 5:
                    messageFilter = (MessageFilter) C1460d.m465Q(parcel, i, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) C1460d.m465Q(parcel, i, PendingIntent.CREATOR);
                    break;
                case 7:
                    iM437G2 = C1460d.m437G1(parcel, i);
                    break;
                case '\b':
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case '\t':
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
                case '\n':
                    bArrM456N = C1460d.m456N(parcel, i);
                    break;
                case 11:
                    zM431E1 = C1460d.m431E1(parcel, i);
                    break;
                case '\f':
                    iBinderM434F3 = C1460d.m434F1(parcel, i);
                    break;
                case '\r':
                    zM431E2 = C1460d.m431E1(parcel, i);
                    break;
                case 14:
                    clientAppContext = (ClientAppContext) C1460d.m465Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                case 15:
                    zM431E3 = C1460d.m431E1(parcel, i);
                    break;
                case 16:
                    iM437G3 = C1460d.m437G1(parcel, i);
                    break;
                case 17:
                    iM437G4 = C1460d.m437G1(parcel, i);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new SubscribeRequest(iM437G1, iBinderM434F1, strategy, iBinderM434F2, messageFilter, pendingIntent, iM437G2, strM468R, strM468R2, bArrM456N, zM431E1, iBinderM434F3, zM431E2, clientAppContext, zM431E3, iM437G3, iM437G4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
