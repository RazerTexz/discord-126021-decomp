package b.i.a.f.h.k;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.icing.zzo;
import com.google.android.gms.internal.icing.zzw;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements Parcelable$Creator<zzo> {
    @Override // android.os.Parcelable$Creator
    public final zzo createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        Status status = null;
        ArrayList arrayListV = null;
        String[] strArrS = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                status = (Status) b.c.a.a0.d.Q(parcel, i, Status.CREATOR);
            } else if (c == 2) {
                arrayListV = b.c.a.a0.d.V(parcel, i, zzw.CREATOR);
            } else if (c != 3) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                strArrS = b.c.a.a0.d.S(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzo(status, arrayListV, strArrS);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzo[] newArray(int i) {
        return new zzo[i];
    }
}
