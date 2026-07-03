package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.internal.zza;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.w */
/* JADX INFO: loaded from: classes3.dex */
public final class C4314w implements Parcelable.Creator<zza> {
    @Override // android.os.Parcelable.Creator
    public final zza createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        int iM437G1 = 0;
        int iM437G2 = 0;
        int iM437G3 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c == 2) {
                iM437G2 = C1460d.m437G1(parcel, i);
            } else if (c != 3) {
                C1460d.m510d2(parcel, i);
            } else {
                iM437G3 = C1460d.m437G1(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zza(iM437G1, iM437G2, iM437G3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
