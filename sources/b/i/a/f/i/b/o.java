package b.i.a.f.i.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.measurement.internal.zzap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements Parcelable.Creator<zzap> {
    @Override // android.os.Parcelable.Creator
    public final zzap createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        Bundle bundleM = null;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            if (((char) i) != 2) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                bundleM = AnimatableValueParser.M(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzap(bundleM);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzap[] newArray(int i) {
        return new zzap[i];
    }
}
