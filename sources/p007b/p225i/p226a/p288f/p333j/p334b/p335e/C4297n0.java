package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzj;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.n0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4297n0 implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final zzj createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        int iM437G1 = 0;
        ClientAppContext clientAppContext = null;
        int iM437G2 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c == 2) {
                clientAppContext = (ClientAppContext) C1460d.m465Q(parcel, i, ClientAppContext.CREATOR);
            } else if (c != 3) {
                C1460d.m510d2(parcel, i);
            } else {
                iM437G2 = C1460d.m437G1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzj(iM437G1, clientAppContext, iM437G2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj[] newArray(int i) {
        return new zzj[i];
    }
}
