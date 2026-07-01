package b.i.a.f.e.k;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements Parcelable.Creator<RootTelemetryConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final RootTelemetryConfiguration createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        int iG1 = 0;
        boolean zE1 = false;
        boolean zE2 = false;
        int iG2 = 0;
        int iG3 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 2) {
                zE1 = AnimatableValueParser.E1(parcel, i);
            } else if (c == 3) {
                zE2 = AnimatableValueParser.E1(parcel, i);
            } else if (c == 4) {
                iG2 = AnimatableValueParser.G1(parcel, i);
            } else if (c != 5) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                iG3 = AnimatableValueParser.G1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new RootTelemetryConfiguration(iG1, zE1, zE2, iG2, iG3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ RootTelemetryConfiguration[] newArray(int i) {
        return new RootTelemetryConfiguration[i];
    }
}
