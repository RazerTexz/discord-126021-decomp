package b.i.a.f.e.k;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.zzi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements Parcelable.Creator<zzi> {
    @Override // android.os.Parcelable.Creator
    public final zzi createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        Bundle bundleM = null;
        Feature[] featureArr = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                bundleM = AnimatableValueParser.M(parcel, i);
            } else if (c == 2) {
                featureArr = (Feature[]) AnimatableValueParser.U(parcel, i, Feature.CREATOR);
            } else if (c == 3) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c != 4) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) AnimatableValueParser.Q(parcel, i, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzi(bundleM, featureArr, iG1, connectionTelemetryConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzi[] newArray(int i) {
        return new zzi[i];
    }
}
