package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.k.n0;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new n0();
    public Bundle j;
    public Feature[] k;
    public int l;

    @Nullable
    public ConnectionTelemetryConfiguration m;

    public zzi() {
    }

    public zzi(Bundle bundle, Feature[] featureArr, int i, @Nullable ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.j = bundle;
        this.k = featureArr;
        this.l = i;
        this.m = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.p2(parcel, 1, this.j, false);
        AnimatableValueParser.v2(parcel, 2, this.k, i, false);
        int i2 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        AnimatableValueParser.s2(parcel, 4, this.m, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
