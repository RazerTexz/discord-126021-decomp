package p007b.p225i.p226a.p288f.p337l.p338b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.signin.internal.zak;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.l.b.i */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4344i implements Parcelable.Creator<zak> {
    @Override // android.os.Parcelable.Creator
    public final zak createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        int iM437G1 = 0;
        zas zasVar = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c != 2) {
                C1460d.m510d2(parcel, i);
            } else {
                zasVar = (zas) C1460d.m465Q(parcel, i, zas.CREATOR);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zak(iM437G1, zasVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak[] newArray(int i) {
        return new zak[i];
    }
}
