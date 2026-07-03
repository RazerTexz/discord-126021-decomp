package p007b.p225i.p226a.p288f.p336k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.safetynet.zzf;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.k.e */
/* JADX INFO: loaded from: classes3.dex */
public final class C4331e implements Parcelable.Creator<zzf> {
    @Override // android.os.Parcelable.Creator
    public final zzf createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            if (((char) i) != 2) {
                C1460d.m510d2(parcel, i);
            } else {
                strM468R = C1460d.m468R(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzf(strM468R);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzf[] newArray(int i) {
        return new zzf[i];
    }
}
