package p007b.p225i.p226a.p288f.p313h.p324k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.icing.zzo;
import com.google.android.gms.internal.icing.zzw;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.k.r */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3573r implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final zzo createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        Status status = null;
        ArrayList arrayListM480V = null;
        String[] strArrM471S = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                status = (Status) C1460d.m465Q(parcel, i, Status.CREATOR);
            } else if (c == 2) {
                arrayListM480V = C1460d.m480V(parcel, i, zzw.CREATOR);
            } else if (c != 3) {
                C1460d.m510d2(parcel, i);
            } else {
                strArrM471S = C1460d.m471S(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzo(status, arrayListM480V, strArrM471S);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i) {
        return new zzo[i];
    }
}
