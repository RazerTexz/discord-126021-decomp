package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.k.o0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3372o0 implements Parcelable.Creator<ConnectionTelemetryConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final ConnectionTelemetryConfiguration createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrM459O = null;
        int[] iArrM459O2 = null;
        boolean zM431E1 = false;
        boolean zM431E2 = false;
        int iM437G1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) C1460d.m465Q(parcel, i, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zM431E1 = C1460d.m431E1(parcel, i);
                    break;
                case 3:
                    zM431E2 = C1460d.m431E1(parcel, i);
                    break;
                case 4:
                    iArrM459O = C1460d.m459O(parcel, i);
                    break;
                case 5:
                    iM437G1 = C1460d.m437G1(parcel, i);
                    break;
                case 6:
                    iArrM459O2 = C1460d.m459O(parcel, i);
                    break;
                default:
                    C1460d.m510d2(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zM431E1, zM431E2, iArrM459O, iM437G1, iArrM459O2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ConnectionTelemetryConfiguration[] newArray(int i) {
        return new ConnectionTelemetryConfiguration[i];
    }
}
