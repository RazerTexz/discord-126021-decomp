package b.i.a.f.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.zzs;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements Parcelable.Creator<zzs> {
    @Override // android.os.Parcelable.Creator
    public final zzs createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        boolean zE1 = false;
        String strR = null;
        IBinder iBinderF1 = null;
        boolean zE2 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 2) {
                iBinderF1 = AnimatableValueParser.F1(parcel, i);
            } else if (c == 3) {
                zE1 = AnimatableValueParser.E1(parcel, i);
            } else if (c != 4) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                zE2 = AnimatableValueParser.E1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzs(strR, iBinderF1, zE1, zE2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzs[] newArray(int i) {
        return new zzs[i];
    }
}
