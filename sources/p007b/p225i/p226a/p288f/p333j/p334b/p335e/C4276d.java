package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.internal.zzad;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.d */
/* JADX INFO: loaded from: classes3.dex */
public final class C4276d implements Parcelable.Creator<zzad> {
    @Override // android.os.Parcelable.Creator
    public final zzad createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        String strM468R2 = null;
        int iM437G1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strM468R = C1460d.m468R(parcel, i);
            } else if (c == 2) {
                strM468R2 = C1460d.m468R(parcel, i);
            } else if (c != 1000) {
                C1460d.m510d2(parcel, i);
            } else {
                iM437G1 = C1460d.m437G1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzad(iM437G1, strM468R, strM468R2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzad[] newArray(int i) {
        return new zzad[i];
    }
}
