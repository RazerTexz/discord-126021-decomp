package p007b.p225i.p361c.p365k.p367d;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.appindexing.internal.zzc;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.c.k.d.f */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4568f implements Parcelable.Creator<zzc> {
    @Override // android.os.Parcelable.Creator
    public final zzc createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        String strM468R2 = null;
        byte[] bArrM456N = null;
        int iM437G1 = 0;
        boolean zM431E1 = false;
        boolean zM431E2 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iM437G1 = C1460d.m437G1(parcel, i);
                    break;
                case 2:
                    zM431E1 = C1460d.m431E1(parcel, i);
                    break;
                case 3:
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case 4:
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
                case 5:
                    bArrM456N = C1460d.m456N(parcel, i);
                    break;
                case 6:
                    zM431E2 = C1460d.m431E1(parcel, i);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzc(iM437G1, zM431E1, strM468R, strM468R2, bArrM456N, zM431E2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i) {
        return new zzc[i];
    }
}
