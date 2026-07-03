package p007b.p225i.p226a.p288f.p333j.p334b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.nearby.zzgp;
import com.google.android.gms.internal.nearby.zzgu;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.internal.zzad;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.j.b.g */
/* JADX INFO: loaded from: classes3.dex */
public final class C4323g implements Parcelable.Creator<MessageFilter> {
    @Override // android.os.Parcelable.Creator
    public final MessageFilter createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        ArrayList arrayListM480V = null;
        ArrayList arrayListM480V2 = null;
        ArrayList arrayListM480V3 = null;
        int iM437G1 = 0;
        boolean zM431E1 = false;
        int iM437G2 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                arrayListM480V = C1460d.m480V(parcel, i, zzad.CREATOR);
            } else if (c == 2) {
                arrayListM480V2 = C1460d.m480V(parcel, i, zzgu.CREATOR);
            } else if (c == 3) {
                zM431E1 = C1460d.m431E1(parcel, i);
            } else if (c == 4) {
                arrayListM480V3 = C1460d.m480V(parcel, i, zzgp.CREATOR);
            } else if (c == 5) {
                iM437G2 = C1460d.m437G1(parcel, i);
            } else if (c != 1000) {
                C1460d.m510d2(parcel, i);
            } else {
                iM437G1 = C1460d.m437G1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new MessageFilter(iM437G1, arrayListM480V, arrayListM480V2, zM431E1, arrayListM480V3, iM437G2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessageFilter[] newArray(int i) {
        return new MessageFilter[i];
    }
}
