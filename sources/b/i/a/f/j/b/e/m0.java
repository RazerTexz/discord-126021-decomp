package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.nearby.messages.internal.zze;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 implements Parcelable.Creator<zze> {
    @Override // android.os.Parcelable.Creator
    public final zze createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        int iG1 = 0;
        double d = 0.0d;
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
                AnimatableValueParser.x2(parcel, i, 8);
                d = parcel.readDouble();
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zze(iG1, iG2, d);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zze[] newArray(int i) {
        return new zze[i];
    }
}
