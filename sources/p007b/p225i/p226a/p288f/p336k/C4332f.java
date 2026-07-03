package p007b.p225i.p226a.p288f.p336k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.safetynet.zzh;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.k.f */
/* JADX INFO: loaded from: classes3.dex */
public final class C4332f implements Parcelable.Creator<zzh> {
    @Override // android.os.Parcelable.Creator
    public final zzh createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        int iM437G1 = 0;
        boolean zM431E1 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c != 3) {
                C1460d.m510d2(parcel, i);
            } else {
                zM431E1 = C1460d.m431E1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzh(iM437G1, zM431E1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh[] newArray(int i) {
        return new zzh[i];
    }
}
