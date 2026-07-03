package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3372o0;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new C3372o0();

    /* JADX INFO: renamed from: j */
    public final RootTelemetryConfiguration f20521j;

    /* JADX INFO: renamed from: k */
    public final boolean f20522k;

    /* JADX INFO: renamed from: l */
    public final boolean f20523l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final int[] f20524m;

    /* JADX INFO: renamed from: n */
    public final int f20525n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final int[] f20526o;

    public ConnectionTelemetryConfiguration(@RecentlyNonNull RootTelemetryConfiguration rootTelemetryConfiguration, boolean z2, boolean z3, @Nullable int[] iArr, int i, @Nullable int[] iArr2) {
        this.f20521j = rootTelemetryConfiguration;
        this.f20522k = z2;
        this.f20523l = z3;
        this.f20524m = iArr;
        this.f20525n = i;
        this.f20526o = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m570s2(parcel, 1, this.f20521j, i, false);
        boolean z2 = this.f20522k;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.f20523l;
        parcel.writeInt(262147);
        parcel.writeInt(z3 ? 1 : 0);
        int[] iArr = this.f20524m;
        if (iArr != null) {
            int iM594y3 = C1460d.m594y2(parcel, 4);
            parcel.writeIntArray(iArr);
            C1460d.m418A2(parcel, iM594y3);
        }
        int i2 = this.f20525n;
        parcel.writeInt(262149);
        parcel.writeInt(i2);
        int[] iArr2 = this.f20526o;
        if (iArr2 != null) {
            int iM594y4 = C1460d.m594y2(parcel, 6);
            parcel.writeIntArray(iArr2);
            C1460d.m418A2(parcel, iM594y4);
        }
        C1460d.m418A2(parcel, iM594y2);
    }
}
