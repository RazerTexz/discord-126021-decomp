package b.i.a.f.l.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.signin.internal.zab;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Parcelable.Creator<zab> {
    @Override // android.os.Parcelable.Creator
    public final zab createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        int iG1 = 0;
        Intent intent = null;
        int iG2 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 2) {
                iG2 = AnimatableValueParser.G1(parcel, i);
            } else if (c != 3) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                intent = (Intent) AnimatableValueParser.Q(parcel, i, Intent.CREATOR);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zab(iG1, iG2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zab[] newArray(int i) {
        return new zab[i];
    }
}
