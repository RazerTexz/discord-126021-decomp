package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.ia */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4075ia implements Parcelable.Creator<zzz> {
    @Override // android.os.Parcelable.Creator
    public final zzz createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        long jM440H1 = 0;
        long jM440H2 = 0;
        long jM440H3 = 0;
        String strM468R = null;
        String strM468R2 = null;
        zzku zzkuVar = null;
        String strM468R3 = null;
        zzaq zzaqVar = null;
        zzaq zzaqVar2 = null;
        zzaq zzaqVar3 = null;
        boolean zM431E1 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 2:
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case 3:
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
                case 4:
                    zzkuVar = (zzku) C1460d.m465Q(parcel, i, zzku.CREATOR);
                    break;
                case 5:
                    jM440H1 = C1460d.m440H1(parcel, i);
                    break;
                case 6:
                    zM431E1 = C1460d.m431E1(parcel, i);
                    break;
                case 7:
                    strM468R3 = C1460d.m468R(parcel, i);
                    break;
                case '\b':
                    zzaqVar = (zzaq) C1460d.m465Q(parcel, i, zzaq.CREATOR);
                    break;
                case '\t':
                    jM440H2 = C1460d.m440H1(parcel, i);
                    break;
                case '\n':
                    zzaqVar2 = (zzaq) C1460d.m465Q(parcel, i, zzaq.CREATOR);
                    break;
                case 11:
                    jM440H3 = C1460d.m440H1(parcel, i);
                    break;
                case '\f':
                    zzaqVar3 = (zzaq) C1460d.m465Q(parcel, i, zzaq.CREATOR);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzz(strM468R, strM468R2, zzkuVar, jM440H1, zM431E1, strM468R3, zzaqVar, jM440H2, zzaqVar2, jM440H3, zzaqVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}
