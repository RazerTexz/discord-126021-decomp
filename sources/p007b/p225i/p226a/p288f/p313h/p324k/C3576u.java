package p007b.p225i.p226a.p288f.p313h.p324k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzh;
import com.google.android.gms.internal.icing.zzi;
import com.google.android.gms.internal.icing.zzw;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.h.k.u */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3576u implements Parcelable.Creator<zzw> {
    @Override // android.os.Parcelable.Creator
    public final zzw createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        zzi zziVar = null;
        String strM468R = null;
        zzh zzhVar = null;
        String strM468R2 = null;
        long jM440H1 = 0;
        int iM437G1 = 0;
        boolean zM431E1 = false;
        int iM437G2 = -1;
        int iM437G3 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    zziVar = (zzi) C1460d.m465Q(parcel, i, zzi.CREATOR);
                    break;
                case 2:
                    jM440H1 = C1460d.m440H1(parcel, i);
                    break;
                case 3:
                    iM437G1 = C1460d.m437G1(parcel, i);
                    break;
                case 4:
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case 5:
                    zzhVar = (zzh) C1460d.m465Q(parcel, i, zzh.CREATOR);
                    break;
                case 6:
                    zM431E1 = C1460d.m431E1(parcel, i);
                    break;
                case 7:
                    iM437G2 = C1460d.m437G1(parcel, i);
                    break;
                case '\b':
                    iM437G3 = C1460d.m437G1(parcel, i);
                    break;
                case '\t':
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzw(zziVar, jM440H1, iM437G1, strM468R, zzhVar, zM431E1, iM437G2, iM437G3, strM468R2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzw[] newArray(int i) {
        return new zzw[i];
    }
}
