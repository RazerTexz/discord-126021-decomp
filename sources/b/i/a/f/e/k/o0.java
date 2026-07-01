package b.i.a.f.e.k;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements Parcelable.Creator<ConnectionTelemetryConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final ConnectionTelemetryConfiguration createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrO = null;
        int[] iArrO2 = null;
        boolean zE1 = false;
        boolean zE2 = false;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) AnimatableValueParser.Q(parcel, i, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zE1 = AnimatableValueParser.E1(parcel, i);
                    break;
                case 3:
                    zE2 = AnimatableValueParser.E1(parcel, i);
                    break;
                case 4:
                    iArrO = AnimatableValueParser.O(parcel, i);
                    break;
                case 5:
                    iG1 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 6:
                    iArrO2 = AnimatableValueParser.O(parcel, i);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zE1, zE2, iArrO, iG1, iArrO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ConnectionTelemetryConfiguration[] newArray(int i) {
        return new ConnectionTelemetryConfiguration[i];
    }
}
