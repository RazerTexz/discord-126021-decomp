package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3356g0;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new C3356g0();

    /* JADX INFO: renamed from: j */
    public final int f20541j;

    /* JADX INFO: renamed from: k */
    public final boolean f20542k;

    /* JADX INFO: renamed from: l */
    public final boolean f20543l;

    /* JADX INFO: renamed from: m */
    public final int f20544m;

    /* JADX INFO: renamed from: n */
    public final int f20545n;

    public RootTelemetryConfiguration(int i, boolean z2, boolean z3, int i2, int i3) {
        this.f20541j = i;
        this.f20542k = z2;
        this.f20543l = z3;
        this.f20544m = i2;
        this.f20545n = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20541j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        boolean z2 = this.f20542k;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.f20543l;
        parcel.writeInt(262147);
        parcel.writeInt(z3 ? 1 : 0);
        int i3 = this.f20544m;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        int i4 = this.f20545n;
        parcel.writeInt(262149);
        parcel.writeInt(i4);
        C1460d.m418A2(parcel, iM594y2);
    }
}
