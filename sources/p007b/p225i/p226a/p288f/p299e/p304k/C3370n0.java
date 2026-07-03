package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.zzi;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.k.n0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3370n0 implements Parcelable.Creator<zzi> {
    @Override // android.os.Parcelable.Creator
    public final zzi createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        Bundle bundleM453M = null;
        Feature[] featureArr = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int iM437G1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                bundleM453M = C1460d.m453M(parcel, i);
            } else if (c == 2) {
                featureArr = (Feature[]) C1460d.m477U(parcel, i, Feature.CREATOR);
            } else if (c == 3) {
                iM437G1 = C1460d.m437G1(parcel, i);
            } else if (c != 4) {
                C1460d.m510d2(parcel, i);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) C1460d.m465Q(parcel, i, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new zzi(bundleM453M, featureArr, iM437G1, connectionTelemetryConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzi[] newArray(int i) {
        return new zzi[i];
    }
}
