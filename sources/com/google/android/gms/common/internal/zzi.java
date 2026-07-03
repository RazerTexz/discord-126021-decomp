package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3370n0;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new C3370n0();

    /* JADX INFO: renamed from: j */
    public Bundle f20555j;

    /* JADX INFO: renamed from: k */
    public Feature[] f20556k;

    /* JADX INFO: renamed from: l */
    public int f20557l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public ConnectionTelemetryConfiguration f20558m;

    public zzi() {
    }

    public zzi(Bundle bundle, Feature[] featureArr, int i, @Nullable ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f20555j = bundle;
        this.f20556k = featureArr;
        this.f20557l = i;
        this.f20558m = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m558p2(parcel, 1, this.f20555j, false);
        C1460d.m582v2(parcel, 2, this.f20556k, i, false);
        int i2 = this.f20557l;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        C1460d.m570s2(parcel, 4, this.f20558m, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
