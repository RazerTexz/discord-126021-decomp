package b.i.a.f.e.k;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements Parcelable$Creator<ConnectionTelemetryConfiguration> {
    @Override // android.os.Parcelable$Creator
    public final ConnectionTelemetryConfiguration createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
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
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) b.c.a.a0.d.Q(parcel, i, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 3:
                    zE2 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 4:
                    iArrO = b.c.a.a0.d.O(parcel, i);
                    break;
                case 5:
                    iG1 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 6:
                    iArrO2 = b.c.a.a0.d.O(parcel, i);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zE1, zE2, iArrO, iG1, iArrO2);
    }

    @Override // android.os.Parcelable$Creator
    public final /* bridge */ /* synthetic */ ConnectionTelemetryConfiguration[] newArray(int i) {
        return new ConnectionTelemetryConfiguration[i];
    }
}
