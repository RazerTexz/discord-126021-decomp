package b.i.a.f.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.zzn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements Parcelable.Creator<zzn> {
    @Override // android.os.Parcelable.Creator
    public final zzn createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        IBinder iBinderF1 = null;
        boolean zE1 = false;
        boolean zE2 = false;
        boolean zE3 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 2) {
                zE1 = AnimatableValueParser.E1(parcel, i);
            } else if (c == 3) {
                zE2 = AnimatableValueParser.E1(parcel, i);
            } else if (c == 4) {
                iBinderF1 = AnimatableValueParser.F1(parcel, i);
            } else if (c != 5) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                zE3 = AnimatableValueParser.E1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzn(strR, zE1, zE2, iBinderF1, zE3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzn[] newArray(int i) {
        return new zzn[i];
    }
}
