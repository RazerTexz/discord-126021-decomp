package p007b.p225i.p361c.p391o.p392b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.dynamiclinks.internal.zzr;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.c.o.b.n */
/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4781n implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final zzr createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            if (((char) i) != 2) {
                C1460d.m510d2(parcel, i);
            } else {
                strM468R = C1460d.m468R(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzr(strM468R);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i) {
        return new zzr[i];
    }
}
