package p007b.p225i.p226a.p288f.p299e.p300h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.h.l */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3334l implements Parcelable.Creator<Scope> {
    @Override // android.os.Parcelable.Creator
    public final Scope createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        int iM437G1 = 0;
        String strM468R = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c != 2) {
                C1460d.m510d2(parcel, i);
            } else {
                strM468R = C1460d.m468R(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new Scope(iM437G1, strM468R);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Scope[] newArray(int i) {
        return new Scope[i];
    }
}
