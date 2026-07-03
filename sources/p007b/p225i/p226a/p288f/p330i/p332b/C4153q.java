package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.q */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4153q implements Parcelable.Creator<zzaq> {
    @Override // android.os.Parcelable.Creator
    public final zzaq createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        zzap zzapVar = null;
        String strM468R2 = null;
        long jM440H1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 3) {
                zzapVar = (zzap) C1460d.m465Q(parcel, i, zzap.CREATOR);
            } else if (c == 4) {
                strM468R2 = C1460d.m468R(parcel, i);
            } else if (c != 5) {
                C1460d.m510d2(parcel, i);
            } else {
                jM440H1 = C1460d.m440H1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzaq(strM468R, zzapVar, strM468R2, jM440H1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaq[] newArray(int i) {
        return new zzaq[i];
    }
}
