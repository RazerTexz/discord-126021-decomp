package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzap;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.o */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4131o implements Parcelable.Creator<zzap> {
    @Override // android.os.Parcelable.Creator
    public final zzap createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        Bundle bundleM453M = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            if (((char) i) != 2) {
                C1460d.m510d2(parcel, i);
            } else {
                bundleM453M = C1460d.m453M(parcel, i);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzap(bundleM453M);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzap[] newArray(int i) {
        return new zzap[i];
    }
}
