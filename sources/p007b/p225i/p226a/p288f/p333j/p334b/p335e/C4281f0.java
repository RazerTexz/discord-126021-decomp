package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzbz;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.f0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4281f0 implements Parcelable.Creator<zzbz> {
    @Override // android.os.Parcelable.Creator
    public final zzbz createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        zzaf zzafVar = null;
        Strategy strategy = null;
        IBinder iBinderM434F1 = null;
        String strM468R = null;
        String strM468R2 = null;
        IBinder iBinderM434F2 = null;
        ClientAppContext clientAppContext = null;
        int iM437G1 = 0;
        boolean zM431E1 = false;
        boolean zM431E2 = false;
        int iM437G2 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iM437G1 = C1460d.m437G1(parcel, i);
                    break;
                case 2:
                    zzafVar = (zzaf) C1460d.m465Q(parcel, i, zzaf.CREATOR);
                    break;
                case 3:
                    strategy = (Strategy) C1460d.m465Q(parcel, i, Strategy.CREATOR);
                    break;
                case 4:
                    iBinderM434F1 = C1460d.m434F1(parcel, i);
                    break;
                case 5:
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case 6:
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
                case 7:
                    zM431E1 = C1460d.m431E1(parcel, i);
                    break;
                case '\b':
                    iBinderM434F2 = C1460d.m434F1(parcel, i);
                    break;
                case '\t':
                    zM431E2 = C1460d.m431E1(parcel, i);
                    break;
                case '\n':
                    clientAppContext = (ClientAppContext) C1460d.m465Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                case 11:
                    iM437G2 = C1460d.m437G1(parcel, i);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzbz(iM437G1, zzafVar, strategy, iBinderM434F1, strM468R, strM468R2, zM431E1, iBinderM434F2, zM431E2, clientAppContext, iM437G2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbz[] newArray(int i) {
        return new zzbz[i];
    }
}
