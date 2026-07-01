package b.i.c.o.b;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.firebase.dynamiclinks.internal.zzr;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements Parcelable$Creator<zzr> {
    @Override // android.os.Parcelable$Creator
    public final zzr createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            if (((char) i) != 2) {
                b.c.a.a0.d.d2(parcel, i);
            } else {
                strR = b.c.a.a0.d.R(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzr(strR);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ zzr[] newArray(int i) {
        return new zzr[i];
    }
}
