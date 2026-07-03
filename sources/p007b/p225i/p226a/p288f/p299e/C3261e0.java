package p007b.p225i.p226a.p288f.p299e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzs;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.e0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3261e0 implements Parcelable.Creator<zzs> {
    @Override // android.os.Parcelable.Creator
    public final zzs createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        boolean zM431E1 = false;
        String strM468R = null;
        IBinder iBinderM434F1 = null;
        boolean zM431E2 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 2) {
                iBinderM434F1 = C1460d.m434F1(parcel, i);
            } else if (c == 3) {
                zM431E1 = C1460d.m431E1(parcel, i);
            } else if (c != 4) {
                C1460d.m510d2(parcel, i);
            } else {
                zM431E2 = C1460d.m431E1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzs(strM468R, iBinderM434F1, zM431E1, zM431E2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzs[] newArray(int i) {
        return new zzs[i];
    }
}
