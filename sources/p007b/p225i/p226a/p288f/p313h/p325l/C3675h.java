package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zzae;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.l.h */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3675h implements Parcelable.Creator<zzae> {
    @Override // android.os.Parcelable.Creator
    public final zzae createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        long jM440H1 = 0;
        long jM440H2 = 0;
        String strM468R = null;
        String strM468R2 = null;
        String strM468R3 = null;
        Bundle bundleM453M = null;
        boolean zM431E1 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    jM440H1 = C1460d.m440H1(parcel, i);
                    break;
                case 2:
                    jM440H2 = C1460d.m440H1(parcel, i);
                    break;
                case 3:
                    zM431E1 = C1460d.m431E1(parcel, i);
                    break;
                case 4:
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case 5:
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
                case 6:
                    strM468R3 = C1460d.m468R(parcel, i);
                    break;
                case 7:
                    bundleM453M = C1460d.m453M(parcel, i);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzae(jM440H1, jM440H2, zM431E1, strM468R, strM468R2, strM468R3, bundleM453M);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzae[] newArray(int i) {
        return new zzae[i];
    }
}
