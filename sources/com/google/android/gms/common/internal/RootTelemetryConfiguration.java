package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.k.g0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new g0();
    public final int j;
    public final boolean k;
    public final boolean l;
    public final int m;
    public final int n;

    public RootTelemetryConfiguration(int i, boolean z2, boolean z3, int i2, int i3) {
        this.j = i;
        this.k = z2;
        this.l = z3;
        this.m = i2;
        this.n = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        boolean z2 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(z3 ? 1 : 0);
        int i3 = this.m;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        int i4 = this.n;
        parcel.writeInt(262149);
        parcel.writeInt(i4);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
