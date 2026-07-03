package p007b.p225i.p226a.p288f.p299e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzn;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.c0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3257c0 implements Parcelable.Creator<zzn> {
    @Override // android.os.Parcelable.Creator
    public final zzn createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        IBinder iBinderM434F1 = null;
        boolean zM431E1 = false;
        boolean zM431E2 = false;
        boolean zM431E3 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 2) {
                zM431E1 = C1460d.m431E1(parcel, i);
            } else if (c == 3) {
                zM431E2 = C1460d.m431E1(parcel, i);
            } else if (c == 4) {
                iBinderM434F1 = C1460d.m434F1(parcel, i);
            } else if (c != 5) {
                C1460d.m510d2(parcel, i);
            } else {
                zM431E3 = C1460d.m431E1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzn(strM468R, zM431E1, zM431E2, iBinderM434F1, zM431E3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzn[] newArray(int i) {
        return new zzn[i];
    }
}
