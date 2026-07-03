package p007b.p225i.p226a.p288f.p313h.p324k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzu;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.k.t */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3575t implements Parcelable.Creator<zzu> {
    @Override // android.os.Parcelable.Creator
    public final zzu createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        boolean zM431E1 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            if (((char) i) != 1) {
                C1460d.m510d2(parcel, i);
            } else {
                zM431E1 = C1460d.m431E1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzu(zM431E1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzu[] newArray(int i) {
        return new zzu[i];
    }
}
